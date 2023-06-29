package com.example.borrowbook.controller;

import com.example.borrowbook.model.Book;
import com.example.borrowbook.model.BookRental;
import com.example.borrowbook.service.IBookRentalService;
import com.example.borrowbook.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/bookRental")
public class BookRentalController {
    @Autowired
    private IBookRentalService bookRentalService;
    @Autowired
    private IBookService bookService;


    @GetMapping("/add/{id}")
    String addBookRental(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        book.setQuantity(book.getQuantity() - 1);
        if (book.getQuantity() < 0) {
            model.addAttribute("message", "Hết Sách");
            return "/fail";
        }
        String bookRentalCode = "";
        boolean flag;
        do {
            flag = false;
            int num1 = (int) (Math.random() * 1000) +10000;
            bookRentalCode += num1;
            List<BookRental> bookRentalList = bookRentalService.getListBookRental();
            for (int i = 0; i < bookRentalList.size(); i++) {
                if (bookRentalList.get(i).getBookRentalCode().equals(bookRentalCode)) {
                    flag = true;
                }
            }
        } while (flag);
        BookRental bookRental = new BookRental();
        bookRental.setBookRentalCode(bookRentalCode);
        bookRental.setBookRentalDate(String.valueOf(LocalDate.now()));
        bookRental.setBook(book);
        bookRentalService.updateBookRental(bookRental);
        model.addAttribute("message", bookRentalCode);
        bookService.updateBook(book);
        return "success";
    }
    @PostMapping("/returnBook")
    public String returnBook(@RequestParam ("bookRentalCode")String bookRentalCode){
        List<BookRental>bookRentalList = bookRentalService.getListBookRental();
        for (int i = 0; i < bookRentalList.size(); i++) {
            if (bookRentalCode.equals(bookRentalList.get(i).getBookRentalCode())){
                Book book = bookService.getBookById(bookRentalList.get(i).getBook().getId());
                book.setQuantity(book.getQuantity()+1);
                bookService.updateBook(book);
                bookRentalService.deleteBookRental(bookRentalList.get(i));
                return "redirect:/book";
            }
        }
        return "/fail";
    }
    @GetMapping("/returnBook")
    public String showForm(){
        return "/returnBook";
    }
}
