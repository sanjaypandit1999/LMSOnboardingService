package com.bridgelabz.onboarding.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bridgelabz.onboarding.dto.LmsOnboardingDTO;
import lombok.Data;

@Document(collection="OnboardingCandidate")
@Data
public class LmsOnboarding {
	
	@Transient
    public static final String SEQUENCE_NAME = "candidate_sequence";
	
	@Id
	private long id;
	
	public String firstName;
	public String middleName;
	public String lastName;
	public String email;
	public String mobileNum;
	public String hiredCity;
	public String parentName;
	public String parentMobile;
	public String temporaryAddress;
	public String ParentOccupation;
	public String parentAnnualSalary;
	public String permanentAddress;
	public String profileImage;
	public String folderId;
	public String status;
	public LocalDate creatorStamp;
	public LocalDate updateStamp;
	
	private LmsBankInfo candidateBankInfo;


	private LmsQualificationInfo CandidateQualificationInfo;
	
	
	
	public LmsOnboarding() {
	}
	


	public void addData(LmsOnboardingDTO lmsOnboardingDTO) {
		// TODO Auto-generated constructor stub
		this.firstName = lmsOnboardingDTO.getFirstName();
		this.middleName = lmsOnboardingDTO.getMiddleName();
		this.lastName = lmsOnboardingDTO.getLastName();
		this.email = lmsOnboardingDTO.getEmail();
		this.mobileNum =lmsOnboardingDTO.getMobileNum();
		this.hiredCity = lmsOnboardingDTO.getHiredCity();
		this.parentName = lmsOnboardingDTO.getParentName();
		this.parentMobile = lmsOnboardingDTO.getParentMobile();
		this.temporaryAddress = lmsOnboardingDTO.getTemporaryAddress();
		this.ParentOccupation = lmsOnboardingDTO.getParentOccupation();
		this.parentAnnualSalary = lmsOnboardingDTO.getParentAnnualSalary();
		this.profileImage =lmsOnboardingDTO.getProfileImage();
		this.folderId = lmsOnboardingDTO.getFolderId();
		this.status = lmsOnboardingDTO.getStatus();
		this.creatorStamp =lmsOnboardingDTO.getCreatorStamp();
		this.updateStamp =lmsOnboardingDTO.getUpdateStamp();
	}



}
