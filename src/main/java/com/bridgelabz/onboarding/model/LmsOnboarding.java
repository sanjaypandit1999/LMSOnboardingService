package com.bridgelabz.onboarding.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bridgelabz.onboarding.dto.LmsOnboardingDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "onboarding_candidate")
@Data
public class LmsOnboarding {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	public LmsOnboarding() {
	}
	


	public LmsOnboarding(long id, LmsOnboardingDTO lmsOnboardingDTO) {
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
