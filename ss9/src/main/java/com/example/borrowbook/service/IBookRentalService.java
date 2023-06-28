package com.example.borrowbook.service;

import com.example.borrowbook.model.BookRental;

import java.util.List;

public interface IBookRentalService {
    List<BookRental>getListBookRental();
    void addBookRental(BookRental bookRental);
}
