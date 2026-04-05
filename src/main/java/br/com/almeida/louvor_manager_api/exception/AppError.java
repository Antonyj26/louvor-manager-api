package br.com.almeida.louvor_manager_api.exception;

public class AppError extends RuntimeException {

	public AppError(String message) {
		super(message);
	}
}
