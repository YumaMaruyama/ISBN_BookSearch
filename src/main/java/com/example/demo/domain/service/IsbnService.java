package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.IsbnDTO;

@Service
public class IsbnService {

	@Autowired
	@Qualifier("isbnSearchRestTemplate")
	RestTemplate restTemplate;

	private static final String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:{isbn}";

	public IsbnDTO service(String isbn) {
		System.out.println("service到達");
		System.out.println("isbn  "  + isbn);


		return restTemplate.getForObject(url,IsbnDTO.class,isbn);
	}
}
