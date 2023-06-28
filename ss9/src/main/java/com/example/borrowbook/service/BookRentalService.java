package com.example.borrowbook.service;

import com.example.borrowbook.model.BookRental;
import com.example.borrowbook.repository.IBookRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentalService implements IBookRentalService {
    @Autowired
    IBookRentalRepository bookRentalRepository;
    @Override
    public List<BookRental> getListBookRental() {
        List<BookRental>bookRentalList = bookRentalRepository.findAll();
        return null;
    }

    @Override
    public void addBookRental(BookRental bookRental) {

    }
}
