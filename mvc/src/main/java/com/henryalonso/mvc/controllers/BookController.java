package com.henryalonso.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.henryalonso.mvc.services.BookService;


@Controller
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@GetMapping("/books/{bookId}")
	public String showBook(Model model, @PathVariable("bookId") Long bookId) {
		model.addAttribute("book", bookService.findBook(bookId ));
		return "show.jsp";
	}
	
}
