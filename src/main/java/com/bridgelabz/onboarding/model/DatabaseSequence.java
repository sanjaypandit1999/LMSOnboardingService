package com.bridgelabz.onboarding.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class DatabaseSequence {
	@Id
	private String id;

	private long seq;
}
