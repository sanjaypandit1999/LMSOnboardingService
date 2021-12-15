package com.bridgelabz.onboarding.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LmsOnboardingDTO {

	@NotNull
	public String firstName;
	@NotNull
	public String middleName;
	@NotNull
	public String lastName;
	@NotNull
	public String email;
	@NotNull
	public String mobileNum;
	@NotNull
	public String hiredCity;
	@NotNull
	public String parentName;
	@NotNull
	public String parentMobile;
	@NotNull
	public String temporaryAddress;
	@NotNull
	public String ParentOccupation;
	@NotNull
	public String parentAnnualSalary;
	@NotNull
	public String permanentAddress;
	@NotNull
	public String profileImage;
	@NotNull
	public String folderId;
	@NotNull
	public String status;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate creatorStamp;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate updateStamp;

	private long bank_Id;

	private long qualification_Id;
	

}
