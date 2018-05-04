package com.tumv.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class StudentLogin {
	@NonNull
	private String userName;
	@NonNull
	private String password;
}
