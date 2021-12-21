package com.bridgelabz.onboarding.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.onboarding.dto.LmsBankInfoDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
import com.bridgelabz.onboarding.exception.LmsOnboardingException;
import com.bridgelabz.onboarding.model.LmsBankInfo;
import com.bridgelabz.onboarding.repository.LmsBankRepository;
import com.bridgelabz.onboarding.util.JwtToken;
@Service
public class LmsBankService implements ILmsBankService {
	@Autowired
	JwtToken jwtToken;
	@Autowired
	LmsBankRepository bankRepository;
	@Autowired
	ModelMapper mapper;

	@Override
	public ResponseDTO addingBankDetails(String token, LmsBankInfoDTO bankInfoDTO) {
		// TODO Auto-generated method stub
			LmsBankInfo lmsBankInfo = mapper.map(bankInfoDTO, LmsBankInfo.class);
			bankRepository.save(lmsBankInfo);
			return new ResponseDTO("Added Bank Details: ", lmsBankInfo);	
	}

	@Override
	public ResponseDTO getAllBankDeatils(String token) {
		List<LmsBankInfo> allCandidate = bankRepository.findAll();
		return new ResponseDTO("List of all onboarding candidate data", allCandidate);
	}

	@Override
	public ResponseDTO updateBankInfo(String token,long id, LmsBankInfoDTO bankDTO) {
		Optional<LmsBankInfo> isUserPresent = bankRepository.findById(id);
		if (isUserPresent.isPresent()) 
		{
			isUserPresent.get().setAadharNumber(bankDTO.getAadharNumber());
			isUserPresent.get().setAadharPath(bankDTO.getAadharPath());
			isUserPresent.get().setBankAccountNumber(bankDTO.getBankAccountNumber());
			isUserPresent.get().setBankName(bankDTO.getBankName());
			isUserPresent.get().setCreatorStamp(bankDTO.getCreatorStamp());
			isUserPresent.get().setIfscCode(bankDTO.getIfscCode());
			isUserPresent.get().setPanNumber(bankDTO.getPanNumber());
			isUserPresent.get().setPanPath(bankDTO.getPanPath());
			isUserPresent.get().setPassbookPath(bankDTO.getPassbookPath());
			isUserPresent.get().setUpdateStamp(LocalDate.now());
			bankRepository.save(isUserPresent.get());
			return new ResponseDTO("Candidate Bank Data Successfully Updated", jwtToken.createToken(isUserPresent.get().getId()));
		} 
		else 
		{
				throw new LmsOnboardingException("Candidate to be Updated Not found");
		}
		
	}

	@Override
	public void deleteBankDetails(String token,long id) {
		Optional<LmsBankInfo> isPresent = bankRepository.findById(id);
		if (isPresent.isPresent()) {
			bankRepository.deleteById(id);
		} else {
			throw new LmsOnboardingException(400,"User not found");
		}

		
	}

}
