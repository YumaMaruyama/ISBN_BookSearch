package com.example.demo.model;

import lombok.Data;

@Data
public class IsbnAccessInfoDTO {

	String country;

	String viewability;

	boolean embeddable;

	boolean publicDomail;

	String textToSpeechPermission;

	IsbnEpubDTO epub;

	IsbnPdfDTO pdf;

	String webReaderLink;

	String accessViewStatus;

	boolean quoteSharingAllowed;

}
