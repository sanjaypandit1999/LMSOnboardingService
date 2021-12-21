package com.bridgelabz.onboarding.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bridgelabz.onboarding.dto.LmsBankInfoDTO;

import lombok.Data;

@Document(collection ="bank_info")
@Data
public class LmsBankInfo {
	@Transient
    public static final String SEQUENCE_NAME = "bankId_sequence";
	
	@Id
	private long id;

	public String panNumber;
	public String aadharNumber;
	public String bankName;
	public String bankAccountNumber;
	public String ifscCode;
	public String passbookPath;
	public String panPath;
	public String aadharPath;
	public LocalDate creatorStamp;
	public LocalDate updateStamp;
	
	public LmsBankInfo() {
	
	}

	public void addBankInfo(LmsBankInfoDTO bankInfoDTO) {
		this.panNumber = bankInfoDTO.getPanNumber();
		this.aadharNumber = bankInfoDTO.getAadharNumber();
		this.bankName = bankInfoDTO.getBankName();
		this.bankAccountNumber = bankInfoDTO.getBankAccountNumber();
		this.ifscCode = bankInfoDTO.getIfscCode();
		this.passbookPath = bankInfoDTO.getPassbookPath();
		this.panPath = bankInfoDTO.getPanPath();
		this.aadharPath = bankInfoDTO.getAadharPath();
		this.creatorStamp = bankInfoDTO.getCreatorStamp();
		this.updateStamp = bankInfoDTO.getUpdateStamp();
	}
	

}
