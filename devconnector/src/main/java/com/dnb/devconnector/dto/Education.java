package com.dnb.devconnector.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Education {

	@Id
	private String educationId;
	private String school;
	private String degree;
  private 	String fieldOfStudy;
	private LocalDate educationDate;
	private String description;
	
	
	
	
}
