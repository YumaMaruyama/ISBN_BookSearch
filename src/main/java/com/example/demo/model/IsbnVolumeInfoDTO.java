package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class IsbnVolumeInfoDTO {

	String title;

	String subtitle;

	List<String> authors = new ArrayList<>();

	String publishedDate;

	String description;

	List<IsbnIndustryIdentifiersDTO> industryIdentifiers = new ArrayList<>();

	IsbnReadingModesDTO readingModes;

	int pageCount;

	String printType;

	String maturityRating;

	boolean allowAnonLogging;

	String contentVersion;

	IsbnImageLinksDTO imageLinks;

	String language;

	String previewLink;

	String infoLink;

	String canonicalVolumeLink;


}
