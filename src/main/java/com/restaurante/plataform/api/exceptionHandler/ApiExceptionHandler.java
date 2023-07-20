package com.restaurante.plataform.api.exceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.restaurante.plataform.domain.exception.EntityNotFoundException;
import com.restaurante.plataform.domain.exception.ExceptionBusiness;
import com.restaurante.plataform.domain.exception.UseEntityException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final String GENRIC_MSG_FINAL_USER = "Ocorreu um erro interno inesperado no sistema. "
	        + "Tente novamente e se o problema persistir, entre em contato "
	        + "com o administrador do sistema.";
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ProblemType problemType = ProblemType.MEDIA_NOT_SUPORTED;
		
		String detail = String.format("O tipo de media %s não é suportado", ex.getContentType());
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();
		
		
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		Throwable rootCause = ExceptionUtils.getRootCause(ex);
		
		if (rootCause instanceof InvalidFormatException) {
			return handleInvalidFormat((InvalidFormatException) rootCause, headers, status, request);
		}else if (rootCause instanceof PropertyBindingException) {
			return handlePropertyBinding((PropertyBindingException) rootCause, headers, status, request);
		}
		
		ProblemType problemType = ProblemType.MESSAGE_INCOMPREHENSIBLE;
		
		String detail = " O corpo da requisição está inválido. Verifique erro de sintaxe";
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.build();
		
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ProblemType problemType = ProblemType.METHOD_NOT_SUPORTED;
		String detail = "Entidade não pode ser encontrada para atualização, preencha corretamente o código da entidade";
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();

				
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return handleValidationInternal(ex, ex.getBindingResult(), headers, status, request);
				
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> treatEntityNotFoundException(
			EntityNotFoundException ex, WebRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
		String detail = ex.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();
		
		
				
		return handleExceptionInternal(ex, problem,new HttpHeaders(), status, request);
		
	}
	
	@ExceptionHandler(ExceptionBusiness.class)
	public ResponseEntity<?> treatExceptionBusiness(ExceptionBusiness ex,
			WebRequest request){
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.BUSINESS_ERR;
		String detail = ex.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();
		
		return handleExceptionInternal(ex, problem,new HttpHeaders(),
				status, request);
	}
	
	@ExceptionHandler(UseEntityException.class)
	public ResponseEntity<?> treatUseEntityException(UseEntityException ex,
			WebRequest request){
		
		HttpStatus status = HttpStatus.CONFLICT;
		ProblemType problemType = ProblemType.USE_ENTITY;
		String detail = ex.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();
		
		return handleExceptionInternal(ex, problem,new HttpHeaders(),
				status, request);
	}
	
	private ResponseEntity<Object> handleValidationInternal(Exception ex, BindingResult bindingResult, HttpHeaders headers,
			HttpStatus status, WebRequest request){
			
		ProblemType problemType = ProblemType.INVALID_DATA;
		String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";
		
		List<Problem.Object> problemObjects = bindingResult.getAllErrors().stream()
				.map(objectError -> {
					String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
					
					String name = objectError.getObjectName();
					
					if (objectError instanceof FieldError) {
						name = ((FieldError) objectError).getField();
					}
					
					return Problem.Object.builder()
							.name(name)
							.userMessage(message)
							.build();
				})
				.collect(Collectors.toList());
				
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.objects(problemObjects)
				.build();
		
		
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	
	private ResponseEntity<Object> handleInvalidFormat(InvalidFormatException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		
		String path = joinPath(ex.getPath());
		
		ProblemType problemType = ProblemType.MESSAGE_INCOMPREHENSIBLE;
		String detail = String.format("A propriedade '%s' recebeu o valor '%s',  "
				+ "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo '%s'. ",
				path, ex.getValue(), ex.getTargetType().getSimpleName());
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
		
	}
	
	private ResponseEntity<Object> handlePropertyBinding(PropertyBindingException e,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		
		String path = joinPath(e.getPath());
		
		ProblemType problemType = ProblemType.MESSAGE_INCOMPREHENSIBLE;
		String detail = String.format("A propriedade '%s' não existe. "
	            + "Corrija ou remova essa propriedade e tente novamente.", path);
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();
		
		return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		if (body == null) {
			
			body = Problem.builder()
					.timestamp(OffsetDateTime.now())
					.title(status.getReasonPhrase())
					.status(status.value())
					.build();
			
		}else if (body instanceof String) {
			body = Problem.builder()
					.timestamp(OffsetDateTime.now())
					.title((String) body)
					.status(status.value())
					.build();
		}
		
		
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	
	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status,
			ProblemType problemType, String detail){
		
		return Problem.builder()
				.timestamp(OffsetDateTime.now())
				.status(status.value())
				.type(problemType.getUri())
				.title(problemType.getTitle())
				.detail(detail);
	}
	
	private String joinPath(List<Reference> references) {
		return references.stream()
				.map( ref -> ref.getFieldName())
				.collect(Collectors.joining("."));

	}
}
