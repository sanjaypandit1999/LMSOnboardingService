package com.bridgelabz.onboarding.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.onboarding.dto.LmsQualificationDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
import com.bridgelabz.onboarding.exception.LmsOnboardingException;
import com.bridgelabz.onboarding.model.LmsQualificationInfo;
import com.bridgelabz.onboarding.repository.LmsQualificationRepository;
import com.bridgelabz.onboarding.util.JwtToken;

@Service
public class LmsQualificationService implements ILmsQualificationService {
	@Autowired
	JwtToken jwtToken;
	@Autowired
	ModelMapper mapper;
	@Autowired
	LmsQualificationRepository qualificationRepository;
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Override
	public ResponseDTO getQualificationData(String token) {
		List<LmsQualificationInfo> onboardingCandidateList = qualificationRepository.findAll();
		return new ResponseDTO("List of all Qualification Candidate : ", onboardingCandidateList);
		
	}
	

	@SuppressWarnings("static-access")
	@Override
	public ResponseDTO addCandidateQualificationData(String token, LmsQualificationDTO qualificationDTO) {
		// TODO Auto-generated method stub
		LmsQualificationInfo candidate = new LmsQualificationInfo();
		candidate.setId(sequenceGenerator.generateSequence(candidate.SEQUENCE_NAME));
		candidate.addQualificationData(qualificationDTO);
		qualificationRepository.save(candidate);
		return new ResponseDTO("Candidate Qualification is Added :",candidate);
	}


	@Override
	public ResponseDTO updateQualificationDataById(String token, long id, LmsQualificationDTO qualificationDTO) {
		Optional<LmsQualificationInfo> isUserPresent = qualificationRepository.findById(id);
		if (isUserPresent.isPresent()) 
		{
			isUserPresent.get().setDegree(qualificationDTO.getDegree());
			isUserPresent.get().setFiled(qualificationDTO.getFiled());
			isUserPresent.get().setYearOfPassing(qualificationDTO.getYearOfPassing());
			isUserPresent.get().setFinalPercentage(qualificationDTO.getFinalPercentage());
			isUserPresent.get().setAggrPercentage(qualificationDTO.getAggrPercentage());
			isUserPresent.get().setEnggPercentage(qualificationDTO.getEnggPercentage());
			isUserPresent.get().setFinalCertification(qualificationDTO.getFinalCertification());
			isUserPresent.get().setTrainingInstitute(qualificationDTO.getTrainingInstitute());
			isUserPresent.get().setTrainingDuration(qualificationDTO.getTrainingDuration());
			isUserPresent.get().setCourse(qualificationDTO.getCourse());
			qualificationRepository.save(isUserPresent.get());
			return new ResponseDTO("Hiring Candidate Qualification Data Successfully Updated", jwtToken.createToken(isUserPresent.get().getId()));
		}
		else
		{
			throw new LmsOnboardingException(400,"Hiring Candidate Qualification Not found");
		}
	}

	
	@Override
	public void deleteQualificationDataById(String token, long id) {
		Optional<LmsQualificationInfo> isUserPresent = qualificationRepository.findById(id);
		if(isUserPresent.isPresent())
		{
			qualificationRepository.deleteById(id);
		}
		
	}


}
