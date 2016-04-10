package com.ori.apps.web.spring.smartsence.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ori.apps.web.spring.smartsence.dao.Response;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(BadSqlGrammarException.class)
	public @ResponseBody Response handleDbExceptions(BadSqlGrammarException ex) {
		ex.printStackTrace();
		Response r = new Response();
		r.setResult("BadSqlGrammarException");
		return r;
	}
	
	@ExceptionHandler(DataAccessException.class)
	public @ResponseBody Response handleDbExceptions(DataAccessException ex) {
		ex.printStackTrace();
		Response r = new Response();
		r.setResult(ex.getLocalizedMessage());
		return r;
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDeniedException(AccessDeniedException ex) {
		return "denied";
	}

}
