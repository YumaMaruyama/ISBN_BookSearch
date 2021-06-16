package com.example.demo.model;

import lombok.Data;

@Data
public class VolumeInfoForm {

	//@Pattern(regexp = "^978\\d{10}$")
	String identifier;

	String title;

	String subtitle;

	String authors;

	int pageCount;

	String publishedDate;

	String description;
}
