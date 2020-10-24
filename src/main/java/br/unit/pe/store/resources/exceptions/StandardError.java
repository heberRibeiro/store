package br.unit.pe.store.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant timaastamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {

	}

	public StandardError(Instant timaastamp, Integer status, String error, String message, String path) {
		this.timaastamp = timaastamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimaastamp() {
		return timaastamp;
	}

	public void setTimaastamp(Instant timaastamp) {
		this.timaastamp = timaastamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
