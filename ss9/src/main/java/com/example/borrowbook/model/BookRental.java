package com.example.borrowbook.model;

import javax.persistence.*;

@Entity
@Table(name = "bookRental")
public class BookRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookRentalCode;
    private String bookRentalDate;
    private String returnDate;
    @JoinColumn
    @ManyToOne
    private Book book;

    public BookRental() {
    }

    public BookRental(int id, String bookRentalCode, String bookRentalDate, String returnDate, Book book) {
        this.id = id;
        this.bookRentalCode = bookRentalCode;
        this.bookRentalDate = bookRentalDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookRentalCode() {
        return bookRentalCode;
    }

    public void setBookRentalCode(String bookRentalCode) {
        this.bookRentalCode = bookRentalCode;
    }

    public String getBookRentalDate() {
        return bookRentalDate;
    }

    public void setBookRentalDate(String bookRentalDate) {
        this.bookRentalDate = bookRentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
