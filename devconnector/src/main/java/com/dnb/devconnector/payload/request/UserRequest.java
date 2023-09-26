package com.dnb.devconnector.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class UserRequest {

	 @NotBlank(message="username is needed")
	  private String userName;
	  
	  private String email;
		@NotBlank(message =" date should not be null")
	  private String password;
	


}
