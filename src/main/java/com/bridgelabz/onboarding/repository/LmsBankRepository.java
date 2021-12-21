package com.bridgelabz.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.onboarding.model.LmsBankInfo;

public interface LmsBankRepository extends JpaRepository<LmsBankInfo, Long>{

}
