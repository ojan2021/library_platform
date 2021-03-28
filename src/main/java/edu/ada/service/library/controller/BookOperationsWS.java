package edu.ada.service.library.controller;

import org.springframework.http.ResponseEntity;

public interface BookOperationsWS {

    ResponseEntity listCategory();
    ResponseEntity listBooks();
    ResponseEntity listAvailableBooks();
    ResponseEntity searchByCategory(String category);
    ResponseEntity searchByTitle(String title);
    ResponseEntity searchByAuthor(String author);
    ResponseEntity listMetaData();
}
