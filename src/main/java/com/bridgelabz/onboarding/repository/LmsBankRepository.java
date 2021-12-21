package com.bridgelabz.onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.onboarding.model.LmsBankInfo;

@Repository
public interface LmsBankRepository extends MongoRepository<LmsBankInfo, Long>{

}
