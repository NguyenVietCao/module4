package com.example.borrowbook.service;

import com.example.borrowbook.model.Book;
import com.example.borrowbook.model.BookRental;

import java.util.List;

public interface IBookService {
    List<Book>displayListBook();
    Book getBookById(int id);
   void updateBook(Book book);
}
