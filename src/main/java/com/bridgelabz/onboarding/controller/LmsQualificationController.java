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

import com.bridgelabz.onboarding.dto.LmsQualificationDTO;
import com.bridgelabz.onboarding.dto.ResponseDTO;
import com.bridgelabz.onboarding.services.ILmsQualificationService;

@RestController
@RequestMapping("/candidatequalification")
public class LmsQualificationController {
	
	@Autowired
	ILmsQualificationService qualificationService;
	
	@GetMapping("/getqualification")
	public ResponseEntity<ResponseDTO> getQualificationData(@RequestHeader String token)
	{
		ResponseDTO respDTO = qualificationService.getQualificationData(token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PostMapping("/addqualification")
	public ResponseEntity<ResponseDTO> addCandidateQualificationData(@RequestHeader String token,@RequestBody LmsQualificationDTO qualificationDTO)
	{

		ResponseDTO candidateData = qualificationService.addCandidateQualificationData(token,qualificationDTO);
		return new ResponseEntity<ResponseDTO>(candidateData,HttpStatus.OK);
	}
	

	
	@PutMapping("/updatequalification/{id}")
	public ResponseEntity<ResponseDTO> updateCandidateHiringDataById(@RequestHeader String token,@PathVariable long id,@RequestBody LmsQualificationDTO qualificationDTO) 
	{
		ResponseDTO respDTO = qualificationService.updateQualificationDataById(token,id,qualificationDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletequalification/{id}")
	public ResponseEntity<ResponseDTO> deleteCandidateHiringDataById(@RequestHeader String token,@PathVariable long id) 
	{
		qualificationService.deleteQualificationDataById(token,id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with token : ", id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
