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

@Entity
@Data
public class Education {

	@Id
	//@NotBlank(message= "user id should not be blank")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="education_seq")
	
	@GenericGenerator(name = "education_seq",strategy = "com.dnb.devconnector.utils.DatePrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = DatePrefixedSequenceIdGenerator.INCREMENT_PARAM, value ="1"),
					@Parameter(name= DatePrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%09d"),			
					}
					)
	private String educationId;
	private String school;
	private String degree;
    private String fieldOfStudy;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String description;
 

	  @ManyToOne(fetch=FetchType.EAGER)
	  @JoinColumn(name = "profile_id", referencedColumnName = "profileId")
	private Profile profile;
		
	}

//	  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	  @JoinColumn(name = "profile_id", referencedColumnName = "profileId")
//	private Profile profile;
//	
	

