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

public class Experience {

	@Id
	private String experienceId;
	private String jobTitle;
	private String company;
	private String location;
	private LocalDate date;
	private String description;
}
