package com.dnb.devconnector.payload.request;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class EducationRequest {

	
	@NotBlank(message="Enter school name")
	private String school;
	@NotBlank(message="Enter degree")
	private String degree;
	@NotBlank(message="Enter fieldOfStudy")
    private String fieldOfStudy;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String description;
	
	private String profileId;
}
