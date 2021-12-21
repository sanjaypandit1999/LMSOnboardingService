package com.bridgelabz.onboarding.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.onboarding.model.LmsOnboarding;
@Repository
public interface LmsOnboardingRepository extends MongoRepository<LmsOnboarding, Long> {

	@Query("{ 'email' : ?0 }")
	Optional<LmsOnboarding> findByEmail(String email);

}
