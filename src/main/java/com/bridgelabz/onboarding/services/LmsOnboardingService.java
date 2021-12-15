package com.bridgelabz.onboarding.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.onboarding.dto.LmsOnboardingDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
import com.bridgelabz.onboarding.exception.LmsOnboardingException;
import com.bridgelabz.onboarding.model.LmsOnboarding;
import com.bridgelabz.onboarding.repository.LmsOnboardingRepository;
import com.bridgelabz.onboarding.util.Email;
import com.bridgelabz.onboarding.util.JwtToken;
@Service
public class LmsOnboardingService implements ILmsOnboardingService {
	@Autowired
	JwtToken jwtToken;
	@Autowired
	LmsOnboardingRepository onboardingRepository;
	@Autowired
	ModelMapper modelmapper;
	@Autowired
	Email emailConfig;
	@Autowired
	MailService mailService;

	@Override
	public ResponseDTO getCandidatOnboardingData(String token) {
		// TODO Auto-generated method stub
		List<LmsOnboarding> allCandidate = onboardingRepository.findAll();
		return new ResponseDTO("List of all onboarding candidate data", allCandidate);
	}

	@Override
	public ResponseDTO updateOnboardingCandidateDataById(String token, long id, LmsOnboardingDTO lmsOnboardingDTO) {
		
		Optional<LmsOnboarding> isUserPresent = onboardingRepository.findById(id);
		if (isUserPresent.isPresent()) {
			isUserPresent.get().setFirstName(lmsOnboardingDTO.getFirstName());
			isUserPresent.get().setMiddleName(lmsOnboardingDTO.getMiddleName());
			isUserPresent.get().setLastName(lmsOnboardingDTO.getLastName());
			isUserPresent.get().setEmail(lmsOnboardingDTO.getEmail());
			isUserPresent.get().setMobileNum(lmsOnboardingDTO.getMobileNum());
			isUserPresent.get().setHiredCity(lmsOnboardingDTO.getHiredCity());
			isUserPresent.get().setParentName(lmsOnboardingDTO.getParentName());
			isUserPresent.get().setParentMobile(lmsOnboardingDTO.getParentMobile());
			isUserPresent.get().setTemporaryAddress(lmsOnboardingDTO.getTemporaryAddress());
			isUserPresent.get().setParentOccupation(lmsOnboardingDTO.getParentOccupation());
			isUserPresent.get().setParentAnnualSalary(lmsOnboardingDTO.getParentAnnualSalary());
			isUserPresent.get().setPermanentAddress(lmsOnboardingDTO.getPermanentAddress());
			isUserPresent.get().setProfileImage(lmsOnboardingDTO.getProfileImage());
			isUserPresent.get().setFolderId(lmsOnboardingDTO.getFolderId());
			onboardingRepository.save(isUserPresent.get());
			return new ResponseDTO("Hiring Candidate Data Successfully Updated", isUserPresent);
		} else {
			throw new LmsOnboardingException(400,"Hiring Candidate Not found");
		}
	
	}

	@Override
	public ResponseDTO addOnboardingCandidateData(String token, LmsOnboardingDTO onboardingDTO) {
			LmsOnboarding onboarding = modelmapper.map(onboardingDTO, LmsOnboarding.class);
			onboardingRepository.save(onboarding);
			return new ResponseDTO("Candidate is added", onboarding);

	}

	@Override
	public void deleteOnboardingCandidateDataById(String token, long id) {
		Optional<LmsOnboarding> isPresent = onboardingRepository.findById(id);
		if (isPresent.isPresent()) {
			onboardingRepository.deleteById(id);
		} else {
			throw new LmsOnboardingException("User not found");
		}

	}

	@SuppressWarnings("static-access")
	@Override
	public ResponseDTO jobOfferMail(String token, String email) {
		// TODO Auto-generated method stub
		Optional<LmsOnboarding> isUserPresent = onboardingRepository.findAllByEmail(email);
		System.out.println(email);
		System.out.println(isUserPresent);
		if (isUserPresent.isPresent()) {
			emailConfig.setTo(email);
			emailConfig.setSubject("Job Offer");
			emailConfig.setBody("This is a Candidate Job Offer Notification");
			mailService.send(emailConfig.getTo(), emailConfig.getSubject(), emailConfig.getBody());
			return new ResponseDTO("Email is Successfully Sent to ", email);

		} else {
			throw new LmsOnboardingException("Email Address not Found");
		}
	}

}
