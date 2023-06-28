package com.example.borrowbook.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;
    @Column(columnDefinition = "longText")
    private String description;
    private String author;
    @Min(0)
    private int quantity;
    private boolean isDelete;

    public Book() {
    }

    public Book(int id, String bookName, String description, String author, int quantity, boolean isDelete) {
        this.id = id;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.quantity = quantity;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
