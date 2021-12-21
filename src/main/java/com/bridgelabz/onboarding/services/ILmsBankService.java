package com.bridgelabz.onboarding.services;

import org.springframework.stereotype.Service;

import com.bridgelabz.onboarding.dto.LmsBankInfoDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
@Service
public interface ILmsBankService {

	ResponseDTO addingBankDetails(String token, LmsBankInfoDTO bankInfoDTO);

	ResponseDTO getAllBankDeatils(String token);

	ResponseDTO updateBankInfo(String token,long id, LmsBankInfoDTO bankInfoDTO);

	void deleteBankDetails(String token, long id);

}
