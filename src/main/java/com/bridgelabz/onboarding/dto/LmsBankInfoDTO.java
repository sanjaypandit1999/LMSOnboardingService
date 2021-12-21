package com.bridgelabz.onboarding.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class LmsBankInfoDTO {
	@NotNull
	public String panNumber;
	
	@NotNull
	public String aadharNumber;
	
	@NotNull
	public String bankName;
	
	@NotNull
	public String bankAccountNumber;
	
	@NotNull
	public String ifscCode;
	
	@NotNull
	public String passbookPath;
	
	@NotNull
	public String panPath;
	
	@NotNull
	public String aadharPath;
	
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate creatorStamp;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate updateStamp;

}
