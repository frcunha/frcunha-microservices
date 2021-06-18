package br.com.erudio.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Date timestamp;

	private String mensagem;
	
	private String Details;

	public ExceptionResponse(Date timestamp, String mensagem, String details) {
		super();
		this.timestamp = timestamp;
		this.mensagem = mensagem;
		Details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDetails() {
		return Details;
	}
	
	
}
