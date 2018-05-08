package com.tumv.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {
	@Getter
	@Setter
    private Integer userId;
	@Getter
	@Setter
    private String userName;
	@Getter
	@Setter
    private String password;
}