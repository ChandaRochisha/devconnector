package com.dnb.devconnector.payload.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class ExperienceRequest {

	@NotBlank(message="Enter jobTitle")
	private String jobTitle;
	@NotBlank(message="Enter company")
	private String company;
	private String location;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String description;
	
	private String profileId;
}
