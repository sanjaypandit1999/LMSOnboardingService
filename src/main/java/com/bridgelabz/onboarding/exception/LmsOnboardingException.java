package com.bridgelabz.onboarding.exception;

@SuppressWarnings("serial")
public class LmsOnboardingException extends RuntimeException {

	public LmsOnboardingException(String message) {
		super(message);
	}
	
	public LmsOnboardingException(int statusCode, String statusmessage) {
		super(statusmessage);
	}

	

}
