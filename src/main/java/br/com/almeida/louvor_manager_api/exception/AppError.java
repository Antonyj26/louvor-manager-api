package br.com.almeida.louvor_manager_api.exception;

public class AppError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppError(String message) {
		super(message);
	}
}
