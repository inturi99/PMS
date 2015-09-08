package com.pms.busines.exception;

public class UserException extends Exception{
	 public UserException(){
	        super("User exception occured due to business logic failure");
	    }

	    public UserException(String message){
	        super(message);
	    }

	    public UserException(String message, Exception exception){
	        super(message, exception);
	    }
}
