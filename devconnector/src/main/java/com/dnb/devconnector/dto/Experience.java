package com.dnb.devconnector.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomUserIdGenerator;
import com.dnb.devconnector.utils.DatePrefixedSequenceIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Experience {

	
	@Id
	//@NotBlank(message= "user id should not be blank")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="experience_seq")
	
	@GenericGenerator(name = "experience_seq",strategy = "com.dnb.devconnector.utils.DatePrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = DatePrefixedSequenceIdGenerator.INCREMENT_PARAM, value ="1"),
					@Parameter(name= DatePrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%07d"),
				
					}
					)
	private String experienceId;
	private String jobTitle;
	private String company;
	private String location;
	private LocalDate fromDate;
	private LocalDate toDate;  String description;
	  
	  @ManyToOne(fetch=FetchType.EAGER)
	  @JoinColumn(name = "profile_id", referencedColumnName = "profileId")
	private Profile profile;
}
