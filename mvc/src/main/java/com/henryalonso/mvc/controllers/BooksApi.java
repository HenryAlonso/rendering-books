package com.henryalonso.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.henryalonso.mvc.models.Books;
import com.henryalonso.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;

	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Books> index() {
		return bookService.allBooks();
	}
	
	@RequestMapping("/api/books/{id}")
	public Books show(@PathVariable("id") Long id) {
		Books book = bookService.findBook(id);
		return book;
	}
	
	@PostMapping("/api/books")
	public Books create(@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="pages") Integer numberOfPages) {
		Books book = new Books(title, description, language, numberOfPages);
		return bookService.createBook(book);
	}
	
	
	@PutMapping("/api/books/{id}")
	public Books updateBook(
	        @PathVariable("id") Long id,
	        @RequestParam("title") String title,
	        @RequestParam("description") String description,
	        @RequestParam("language") String language,
	        @RequestParam("pages") Integer numberOfPages) {
		return bookService.updateBook(id, title, description, language, numberOfPages);
	    
	}

	@DeleteMapping("/api/books/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
}
