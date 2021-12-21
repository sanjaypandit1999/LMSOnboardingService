package com.bridgelabz.onboarding.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bridgelabz.onboarding.dto.LmsBankInfoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
@Table(name="bank_info")
public class LmsBankInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public LmsBankInfo(long id,LmsBankInfoDTO bankInfoDTO) {
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
