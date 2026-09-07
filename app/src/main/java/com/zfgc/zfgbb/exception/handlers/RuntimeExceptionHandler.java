package com.zfgc.zfgbb.exception.handlers;

import java.util.ConcurrentModificationException;

import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zfgc.zfgbb.exception.ZfgcInvalidRequestException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RuntimeExceptionHandler {

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ProblemDetail handleDataIntegrityViolation(HttpServletRequest request, DataIntegrityViolationException exception) {
		return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "The request could not be completed due to invalid or conflicting data.");
	}

	@ExceptionHandler(value = ConcurrentModificationException.class)
	public ProblemDetail handleConcurrentModification(HttpServletRequest request, ConcurrentModificationException exception) {
		return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, "The record was modified concurrently. Please retry.");
	}

	@ExceptionHandler(value = ConcurrencyFailureException.class)
	public ProblemDetail handleConcurrencyFailure(HttpServletRequest request, ConcurrencyFailureException exception) {
		return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, "The record was modified concurrently. Please retry.");
	}

	@ExceptionHandler(value = ZfgcInvalidRequestException.class)
	public ProblemDetail handleInvalidRequest(HttpServletRequest request, ZfgcInvalidRequestException exception) {
		return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
	}

}
