package com.project.Crud.demo.exception;

import org.hibernate.service.spi.ServiceException;

@SuppressWarnings("serial")
//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends ServiceException {

	public AlreadyExistException(String message) {
		super(message);
	}
}
