package com.bridgelabz.onboarding.services;

import org.springframework.stereotype.Service;

import com.bridgelabz.onboarding.dto.LmsQualificationDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
@Service
public interface ILmsQualificationService {

	ResponseDTO addCandidateQualificationData(String token, LmsQualificationDTO qualificationDTO);

	void deleteQualificationDataById(String token, long id);

	ResponseDTO updateQualificationDataById(String token, long id, LmsQualificationDTO qualificationDTO);

	ResponseDTO getQualificationData(String token);

}
