package com.eCommmarce.demo.common;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;



@Entity

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = "errorHandling", 
				procedureName = "error_errorHandling", 
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN,name = "actionType", type = String.class),
						@StoredProcedureParameter(mode = ParameterMode.IN,name = "actionValue", type = String.class) 
				}

		) 
})
public class ErrorHandling {
	@Id
	private Integer errorId;

	private String nlErrorCode;
	
	private String nlErrorMessage;

	
	public ErrorHandling() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getErrorId() {
		return errorId;
	}

	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}

	public String getNlErrorCode() {
		return nlErrorCode;
	}

	public void setNlErrorCode(String nlErrorCode) {
		this.nlErrorCode = nlErrorCode;
	}

	public String getNlErrorMessage() {
		return nlErrorMessage;
	}

	public void setNlErrorMessage(String nlErrorMessage) {
		this.nlErrorMessage = nlErrorMessage;
	}

	
	/**
	 * Overrides toString method for converting class to string and vice-versa 
	**/
	@Override
	public String toString() {
		ObjectMapper  mapperObj=new ObjectMapper();
		String jsonStr;
		try{
			jsonStr=mapperObj.writeValueAsString(this);
		}catch(IOException ex){
			
			jsonStr=ex.toString();
		}
		return jsonStr;
	}
	
}
