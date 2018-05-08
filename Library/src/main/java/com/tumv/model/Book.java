package com.tumv.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Book {
	@Getter
	@Setter
	private int bookId;
	@Getter
	@Setter
	private String bookName;
}
