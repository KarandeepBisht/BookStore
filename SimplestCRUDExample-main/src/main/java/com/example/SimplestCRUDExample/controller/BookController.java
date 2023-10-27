package com.example.SimplestCRUDExample.controller;

import com.example.SimplestCRUDExample.Base.BaseController;
import com.example.SimplestCRUDExample.Config.GlobalApiResponse;
import com.example.SimplestCRUDExample.Error.RecordNotFoundException;
import com.example.SimplestCRUDExample.Exception.CustomStatus;
import com.example.SimplestCRUDExample.model.Book;
import com.example.SimplestCRUDExample.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController extends BaseController {

        @Autowired
    BookRepository bookRepository;

    @GetMapping("/getAllBooks")
    public ResponseEntity<GlobalApiResponse<List<Book>>> getAllBooks() {
        try {
            List<Book> bookList = new ArrayList<>();
            bookRepository.findAll().forEach(bookList::add);

            if (bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return ResponseEntity.ok(getSuccessResponse("Data retrieve successfully","200",bookList));
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<GlobalApiResponse<Book>> getBookById(@PathVariable Long id) {
        Optional<Book> bookObj = bookRepository.findById(id);
        if (bookObj.isPresent()) {
            return ResponseEntity.ok(getSuccessResponse("Data retrieve successfully","200",bookObj.get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addBook")
    public ResponseEntity<GlobalApiResponse<Book>> addBook(@RequestBody Book book) {
        try {
            Book bookObj = bookRepository.save(book);
            return ResponseEntity.ok(getSuccessResponse("Data created successfully","200",bookObj));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<GlobalApiResponse<Book>> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            Optional<Book> bookData = bookRepository.findById(id);
            if (bookData.isPresent()) {
                Book updatedBookData = bookData.get();
                updatedBookData.setTitle(book.getTitle());
                updatedBookData.setAuthor(book.getAuthor());

                Book bookObj = bookRepository.save(updatedBookData);
                return ResponseEntity.ok(getSuccessResponse("Data updated successfully","200",bookObj));
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<GlobalApiResponse<HttpStatus>> deleteBook(@PathVariable Long id) {
        try {
            bookRepository.deleteById(id);
            return ResponseEntity.ok(getSuccessResponse("Data updated successfully","200",HttpStatus.OK));
        } catch (Exception e) {
            throw new RecordNotFoundException(CustomStatus.NOT_FOUND_MSG);
        }
    }
    @DeleteMapping("/deleteAllBooks")
    public ResponseEntity<GlobalApiResponse<HttpStatus>> deleteAllBooks() {
        try {
            bookRepository.deleteAll();
            throw new RecordNotFoundException(CustomStatus.NOT_FOUND_MSG);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
