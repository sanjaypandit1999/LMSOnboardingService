package com.bridgelabz.onboarding.services;

import org.springframework.stereotype.Service;

import com.bridgelabz.onboarding.dto.LmsOnboardingDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
@Service
public interface ILmsOnboardingService {

	ResponseDTO getCandidatOnboardingData(String token);

	ResponseDTO updateOnboardingCandidateDataById(String token, long id, LmsOnboardingDTO onboardingDTO);

	ResponseDTO addOnboardingCandidateData(String token, LmsOnboardingDTO lmsOnboardingDTO);

	void deleteOnboardingCandidateDataById(String token, long id);

	ResponseDTO jobOfferMail(String token, String email);

}
