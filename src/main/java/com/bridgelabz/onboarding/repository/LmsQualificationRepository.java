package com.bridgelabz.onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.onboarding.model.LmsQualificationInfo;
@Repository
public interface LmsQualificationRepository extends MongoRepository<LmsQualificationInfo, Long> {

}
