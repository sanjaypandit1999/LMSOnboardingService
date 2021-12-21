package com.bridgelabz.onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.onboarding.dto.LmsBankInfoDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
import com.bridgelabz.onboarding.services.ILmsBankService;

/**
 *  
 *   Purpose: controller for user service
 *
 * @author Sanjay
 *  @version 1.0
 *  @since   12-15-2021
 */

@RestController
@RequestMapping("/bankinfo")
public class LmsBankController {
	@Autowired
	ILmsBankService bankService;
	
	
	@PostMapping("/addbankDetails")
	public ResponseEntity<ResponseDTO> addingBankDetails(@RequestHeader  String token,@RequestBody LmsBankInfoDTO bankInfoDTO){
		ResponseDTO respDTO = bankService.addingBankDetails(token,bankInfoDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getallbankDetails")
	public ResponseEntity<ResponseDTO> getStatus(@RequestHeader String token) {
		ResponseDTO respDTO = bankService.getAllBankDeatils(token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PutMapping("/updatebankdetails/{id}")
	public ResponseEntity<ResponseDTO> updateBankInfo(@RequestHeader  String token,@PathVariable long id, @RequestBody LmsBankInfoDTO bankInfoDTO) {
		ResponseDTO respDTO = bankService.updateBankInfo(token,id,bankInfoDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebankdetails/{id}")
	public ResponseEntity<ResponseDTO> deleteBankDetails(@RequestHeader  String token,@PathVariable long id) {
		bankService.deleteBankDetails(token,id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Contact with id : ", "SUccesfull");
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	

}
