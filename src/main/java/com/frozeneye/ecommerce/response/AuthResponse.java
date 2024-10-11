package com.frozeneye.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class AuthResponse {

    private String status;
    private String jwt;
	

}
