package com.bridgelabz.onboarding.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.onboarding.model.LmsOnboarding;

public interface LmsOnboardingRepository extends JpaRepository<LmsOnboarding, Long> {
	@Query(value = "select * from onboarding_candidate where email= :email", nativeQuery = true)
	Optional<LmsOnboarding> findByEmail(String email);

	

}
