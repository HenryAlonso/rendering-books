package com.henryalonso.mvc.services;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.henryalonso.mvc.models.Books;
import com.henryalonso.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Books> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Books createBook(Books b) {
        return bookRepository.save(b);
    }
    // updates book
    public Books updateBook(Long id, String title, String description, String language, Integer numberOfPages) {
        Optional<Books> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Books bookToUpdate = optionalBook.get();
            bookToUpdate.setTitle(title);
            bookToUpdate.setDescription(description);
            bookToUpdate.setLanguage(language);
            bookToUpdate.setNumberOfPages(numberOfPages);
            return bookRepository.save(bookToUpdate);
        } else {
            throw new EntityNotFoundException("Book not found with id " + id);
        }
    }
    
    // delete a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }

    
    // retrieves a book
    public Books findBook(Long id) {
        Optional<Books> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
