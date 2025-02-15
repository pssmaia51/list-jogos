package com.paulodev.dsjogos.excecoes;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
        super(message);
    }

}
