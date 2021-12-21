package com.bridgelabz.onboarding.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bridgelabz.onboarding.dto.LmsQualificationDTO;

import lombok.Data;

@Document(collection="qualification_info")
public @Data class LmsQualificationInfo {
	
	@Transient
    public static final String SEQUENCE_NAME = "qualification_sequence";
	
	@Id
	private long id;
	
	public boolean diploma;
	public String degree;
	public String filed;
	public String yearOfPassing;
	public String finalPercentage;
	public String aggrPercentage;
	public String enggPercentage;
	public String finalCertification;
	public String trainingInstitute;
	public String trainingDuration;
	public String course;
	
	public LmsQualificationInfo() {
		
	}

	public void addQualificationData(LmsQualificationDTO qualificationDTO) 
	{
		this.degree = qualificationDTO.getDegree();
		this.filed = qualificationDTO.getFiled();
		this.yearOfPassing = qualificationDTO.getYearOfPassing();
		this.finalPercentage = qualificationDTO.getFinalPercentage();
		this.aggrPercentage = qualificationDTO.getAggrPercentage();
		this.enggPercentage = qualificationDTO.getEnggPercentage();
		this.finalCertification = qualificationDTO.getFinalCertification();
		this.trainingInstitute = qualificationDTO.getTrainingInstitute();
		this.trainingDuration = qualificationDTO.getTrainingDuration();
		this.course = qualificationDTO.getCourse();
	}
	

}
