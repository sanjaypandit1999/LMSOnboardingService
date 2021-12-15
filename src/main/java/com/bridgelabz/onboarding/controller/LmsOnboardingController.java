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

import com.bridgelabz.onboarding.dto.LmsOnboardingDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
import com.bridgelabz.onboarding.services.ILmsOnboardingService;

@RestController
@RequestMapping("/lmsonboardingservice")
public class LmsOnboardingController {
	
	@Autowired
	private ILmsOnboardingService onboardingService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getCandidateOnboardingData(@RequestHeader String token)
	{
		
		ResponseDTO resDTO = onboardingService.getCandidatOnboardingData( token);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	
	@PostMapping("/createonboardingcandidate")
	public ResponseEntity<ResponseDTO> addOnboardingCandidateData(@RequestHeader String token,@RequestBody LmsOnboardingDTO lmsOnboardingDTO)
	{

		ResponseDTO resDTO = onboardingService.addOnboardingCandidateData(token,lmsOnboardingDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updateOnboardingcandidateData/{id}")
	public ResponseEntity<ResponseDTO> updateOnboardingCandidateDataById(@RequestHeader String token,@PathVariable long id, @RequestBody LmsOnboardingDTO onboardingDTO) {
		ResponseDTO respDTO = onboardingService.updateOnboardingCandidateDataById(token,id,onboardingDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deleteOnboardingcandidate/{id}")
	public ResponseEntity<ResponseDTO> deleteOnboardingCandidateDataById(@RequestHeader String token,@PathVariable long id) 
	{
		onboardingService.deleteOnboardingCandidateDataById(token, id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with id : ", id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	@PostMapping("/jobofferMail")
	public ResponseEntity<ResponseDTO> jobOfferMail(@RequestHeader String token, @RequestBody String email)
	{
		ResponseDTO respDTO = onboardingService.jobOfferMail(token, email);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
