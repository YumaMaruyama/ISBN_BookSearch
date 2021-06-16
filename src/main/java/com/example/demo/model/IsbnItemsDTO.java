package com.example.demo.model;

import lombok.Data;

@Data
public class IsbnItemsDTO {

	String kind;

	String id;

	String etag;

	String selfLink;

	IsbnVolumeInfoDTO volumeInfo;

	IsbnSaleInfoDTO saleInfo;

	IsbnAccessInfoDTO accessInfo;

	IsbnSearchInfoDTO searchInfo;
}
