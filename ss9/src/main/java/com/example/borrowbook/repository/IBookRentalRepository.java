package com.example.borrowbook.repository;

import com.example.borrowbook.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRentalRepository extends JpaRepository<BookRental,Integer> {
}
