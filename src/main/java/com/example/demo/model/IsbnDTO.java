package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class IsbnDTO {

	String kind;

	int totalItems;

	List<IsbnItemsDTO> items = new ArrayList<>();

}
