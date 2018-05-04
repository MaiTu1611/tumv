package com.tumv.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
	@NonNull
    private Integer userId;
	@NonNull
    private String userName;
	@NonNull
    private String password;
}