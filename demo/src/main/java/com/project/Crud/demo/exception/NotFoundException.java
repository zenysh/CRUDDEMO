package com.project.Crud.demo.exception;

import org.hibernate.service.spi.ServiceException;

@SuppressWarnings("serial")
public class NotFoundException extends ServiceException {
	public NotFoundException(String message) {
		super(message);
	}
}
