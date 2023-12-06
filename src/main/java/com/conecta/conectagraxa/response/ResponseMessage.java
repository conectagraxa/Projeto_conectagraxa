package com.conecta.conectagraxa.response;

import lombok.Data;

@Data
public class ResponseMessage {

    private int id;
    private String idS;

	private String message;

	public ResponseMessage(String message) {
		this.message = message;
	}
	 public ResponseMessage(String message, int id) {
	        this.message = message;
	        this.id = id;
	    }

	 public ResponseMessage(String message, String id) {
	        this.message = message;
	        this.idS = id;
	    }

	public ResponseMessage(Integer id2) {
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MessageResponse [message=" + message + id + "]";
	}

}
