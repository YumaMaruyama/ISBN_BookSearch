package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.service.IsbnService;
import com.example.demo.model.IsbnDTO;
import com.example.demo.model.IsbnImageLinksDTO;
import com.example.demo.model.IsbnIndustryIdentifiersDTO;
import com.example.demo.model.IsbnItemsDTO;
import com.example.demo.model.IsbnVolumeInfoDTO;
import com.example.demo.model.VolumeInfoForm;

@Controller
public class BookSearchController {

	@Autowired
	IsbnService isbnService;

	@GetMapping("/isbnSearchHome")
	public String getIsbnSearchHome(HttpSession session, Model model) {

		return "isbnSearch/isbnSearchHome";
	}

	@PostMapping(value = "/isbnSearchHome", params = "search")
	public String postIsbnSearchHome(@ModelAttribute VolumeInfoForm form, HttpSession session, Model model,
			@RequestParam("isbn") String isbn) {
		System.out.println("book検索(search)到達");
		System.out.println("isbn   " + isbn);

		//バリデーションチェック
		if(!isbn.matches("^978\\d{10}$")) {
			model.addAttribute("result", "正しいISBNコードを入力してください");
			return getIsbnSearchHome(session, model);
		}


		IsbnDTO isbndto = isbnService.service(isbn);
		System.out.println("url  " + isbndto);
		System.out.println("urlGetItems  " + isbndto.getItems());

		//ISBNコードの詳細取得
		List<IsbnItemsDTO> items = isbndto.getItems();
		//ISBNコードのitemsの中のvolumeInfoを取り出す
		for (IsbnItemsDTO item : items) {
			//ISBNコード番号以外の値
			IsbnVolumeInfoDTO volumeInfo = item.getVolumeInfo();
			//ISBNコード番号
			List<IsbnIndustryIdentifiersDTO> industryIdentifiers = volumeInfo.getIndustryIdentifiers();
			System.out.println("industryIdentifiers  " + industryIdentifiers);
			if(industryIdentifiers == null) {
				model.addAttribute("result", "このISBNコードでは情報を取得できませんでした");

				return getIsbnSearchHome(session, model);
			}
			//industryIdentifiersの中のtypeの要素がISBN_13の方を取得
			for (IsbnIndustryIdentifiersDTO typeTest : industryIdentifiers) {
				if ((typeTest.getType().equals("ISBN_13"))) {
					String identifier = typeTest.getIdentifier();
					System.out.println("identifier  " + identifier);
					form.setIdentifier(identifier);
					model.addAttribute("identifier", form.getIdentifier());
				}
			}

			//値を変数に入れる
			String title = volumeInfo.getTitle();
			String subtitle = volumeInfo.getSubtitle();
			List<String> authors = volumeInfo.getAuthors();
//			for (int i = 0; i < authors; i++) {
//				String authorsTest = authors;
//				form.setAuthors(authorsTest);
//				model.addAttribute("authors", authorsTest);
//			}
			for (String authorsTest : authors) {
				form.setAuthors(authorsTest);
				model.addAttribute("authors", authorsTest);
			}
			int pageCount = volumeInfo.getPageCount();
			String publishedDate = volumeInfo.getPublishedDate();
			String stringNumMonth = "mmmm-mm";
			String stringNumYear = "mmmm";

			if(publishedDate.length() == stringNumMonth.length()) {
				System.out.println("年と月取得");
				String getStringNumMonthFrom = publishedDate.substring(0, 4);
				String getStriingNumMonthTo = publishedDate.substring(4, 7);
				System.out.println("From" + getStringNumMonthFrom + "To"+ getStriingNumMonthTo);
				model.addAttribute("publishedDateMonthFrom",getStringNumMonthFrom);
				model.addAttribute("publishedDateMonthTo",getStriingNumMonthTo);


			}else if(publishedDate.length() == stringNumYear.length()) {
				System.out.println("年のみ取得");
				model.addAttribute("publishedDateYear",publishedDate);

			}
			String description = volumeInfo.getDescription();
			System.out.println("description" + description);
			if ((description != null && (!description.isEmpty()))) {
				System.out.println("詳細ifTrue");
				form.setDescription(description);
				model.addAttribute("description", form.getDescription());
			}
			 
			IsbnImageLinksDTO imageLinks = volumeInfo.getImageLinks();
			model.addAttribute("img",imageLinks.getSmallThumbnail());

			//変数の値をFormクラスにセットして、modelでhtmlに出るようにする
			form.setTitle(title);
			model.addAttribute("title", form.getTitle());
			form.setSubtitle(subtitle);
			model.addAttribute("subtitle", form.getSubtitle());
			form.setPageCount(pageCount);
			model.addAttribute("pageCount", form.getPageCount());
//			form.setPublishedDate(publishedDate);
//			model.addAttribute("publishedDate", form.getPublishedDate());

		}
		//model.addAttribute("isbnList",isbndto.getItems());

		return "isbnSearch/isbnSearchResult";
	}

	@PostMapping(value = "/isbnSearchHome", params = "isbnDetail")
	public String postIsbnSearchHomeIsbnDetail(HttpSession session, Model model) {

		return "isbnSearch/isbnDetail";
	}

	@PostMapping(value = "/isbnSearchHome", params = "home")
	public String postIsbnSearchHomeIsbnHome(HttpSession session, Model model) {

		return "isbnSearch/isbnSearchHome";
	}

}
