package com.bridgelabz.onboarding.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.onboarding.dto.LmsOnboardingDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
import com.bridgelabz.onboarding.exception.LmsOnboardingException;
import com.bridgelabz.onboarding.model.LmsBankInfo;
import com.bridgelabz.onboarding.model.LmsOnboarding;
import com.bridgelabz.onboarding.model.LmsQualificationInfo;
import com.bridgelabz.onboarding.repository.LmsBankRepository;
import com.bridgelabz.onboarding.repository.LmsOnboardingRepository;
import com.bridgelabz.onboarding.repository.LmsQualificationRepository;
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
	@Autowired
	SequenceGenerator sequenceGenerator;
	@Autowired
	LmsQualificationRepository qualificationRepository;
	@Autowired
	LmsBankRepository bankRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseDTO getCandidatOnboardingData(String token) {
		// TODO Auto-generated method stub
		boolean isuserpresent = restTemplate.getForObject("http://Lms-admin/user/verify?token=" + token, Boolean.class);
		if (isuserpresent) {
			List<LmsOnboarding> allCandidate = onboardingRepository.findAll();
			return new ResponseDTO("List of all onboarding candidate data", allCandidate);
		} else
			throw new LmsOnboardingException("user not found");
	}

	@Override
	public ResponseDTO updateOnboardingCandidateDataById(String token, long id, LmsOnboardingDTO lmsOnboardingDTO) {
		boolean isuserpresent = restTemplate.getForObject("http://Lms-admin/user/verify?token=" + token, Boolean.class);
		if (isuserpresent) {
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
				throw new LmsOnboardingException(400, "Hiring Candidate Not found");
			}
		} else
			throw new LmsOnboardingException(500, "user not found");

	}

	@SuppressWarnings("static-access")
	@Override
	public ResponseDTO addOnboardingCandidateData(String token, LmsOnboardingDTO onboardingDTO) {
		boolean isuserpresent = restTemplate.getForObject("http://Lms-admin/user/verify?token=" + token, Boolean.class);
		if (isuserpresent) {
			LmsOnboarding lmsOnboarding = new LmsOnboarding();
			lmsOnboarding.setId(sequenceGenerator.generateSequence(lmsOnboarding.SEQUENCE_NAME));
			Optional<LmsQualificationInfo> lmsQualificationInfo = qualificationRepository
					.findById(onboardingDTO.getQualification_Id());
			if (lmsQualificationInfo.isPresent()) {
				lmsOnboarding.setCandidateQualificationInfo(lmsQualificationInfo.get());
			} else
				throw new LmsOnboardingException("qualification id not present");
			Optional<LmsBankInfo> bankInfo = bankRepository.findById(onboardingDTO.getBank_Id());
			if (bankInfo.isPresent()) {
				lmsOnboarding.setCandidateBankInfo(bankInfo.get());
			} else
				throw new LmsOnboardingException("bank id not present");
			lmsOnboarding.addData(onboardingDTO);
			modelmapper.map(onboardingDTO, LmsOnboarding.class);
			onboardingRepository.save(lmsOnboarding);
			return new ResponseDTO("Candidate is added", lmsOnboarding);
		} else
			throw new LmsOnboardingException(500,"user not found");

	}

	@Override
	public void deleteOnboardingCandidateDataById(String token, long id) {
		boolean isuserpresent = restTemplate.getForObject("http://Lms-admin/user/verify?token=" + token, Boolean.class);
		if (isuserpresent) {
			Optional<LmsOnboarding> isPresent = onboardingRepository.findById(id);
			if (isPresent.isPresent()) {
				onboardingRepository.deleteById(id);
			} else {
				throw new LmsOnboardingException("User not found");
			}
		} else
			throw new LmsOnboardingException("user not found");

	}

	@SuppressWarnings("static-access")
	@Override
	public ResponseDTO jobOfferMail(String token, String email) {
		// TODO Auto-generated method stub
		boolean isuserpresent = restTemplate.getForObject("http://Lms-admin/user/verify?token=" + token, Boolean.class);
		if (isuserpresent) {
			Optional<LmsOnboarding> isUserPresent = onboardingRepository.findByEmail(email);
			System.out.println(email);
			System.out.println(isUserPresent.get());
			if (isUserPresent.isPresent()) {
				emailConfig.setTo(email);
				emailConfig.setSubject("Job Offer");
				emailConfig.setBody("This is a Candidate Job Offer Notification");
				mailService.send(emailConfig.getTo(), emailConfig.getSubject(), emailConfig.getBody());
				return new ResponseDTO("Email is Successfully Sent to ", email);

			} else {
				throw new LmsOnboardingException("Email Address not Found");
			}

		} else
			throw new LmsOnboardingException("user not found");

	}
}
