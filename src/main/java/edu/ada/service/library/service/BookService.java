package edu.ada.service.library.service;

import edu.ada.service.library.model.entity.BookEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface BookService {

    ArrayList<String> listCategory();
    ArrayList<String> listBooks();
    String searchByCategory(String category);
    String searchByTitle(String title);
    String searchByAuthor(String author);
}

