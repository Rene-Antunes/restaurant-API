package com.restaurante.plataform.api.exceptionHandler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restaurante.plataform.domain.exception.EntityNotFoundException;
import com.restaurante.plataform.domain.exception.ExceptionBusiness;
import com.restaurante.plataform.domain.exception.UseEntityException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final String GENRIC_MSG_FINAL_USER = "Ocorreu um erro interno inesperado no sistema. "
	        + "Tente novamente e se o problema persistir, entre em contato "
	        + "com o administrador do sistema.";


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
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ProblemType problemType = ProblemType.METHOD_NOT_SUPORTED;
		String detail = "Entidade não pode ser encontrada para atualização";
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();

				
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ProblemType problemType = ProblemType.METHOD_NOT_SUPORTED;
		String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";
		
		//TODO implementar coleta dos campos que estão faltando.
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(GENRIC_MSG_FINAL_USER)
				.build();

				
		return handleExceptionInternal(ex, problem, headers, status, request);
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
}
