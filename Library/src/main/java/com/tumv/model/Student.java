package com.tumv.model;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student {
	@NonNull
	private Integer infoId;
	@NonNull
	private String address;
	@NonNull
	private Double averageScore;
	@NonNull
	private Date dateOfBirth;
	@NonNull
	private Integer studentId;
	@NonNull
	private String studentName;
	@NonNull
	private String studentCode;
}