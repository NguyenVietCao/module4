package com.example.borrowbook.service;

import com.example.borrowbook.model.Book;
import com.example.borrowbook.model.BookRental;
import com.example.borrowbook.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> displayListBook() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    @Override
    public Book getBookById(int id) {

        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }


}

