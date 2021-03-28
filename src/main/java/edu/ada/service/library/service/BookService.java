package edu.ada.service.library.service;

import edu.ada.service.library.model.entity.BookEntity;

import java.util.ArrayList;

public interface BookService {

    ArrayList<String> listCategory();
    ArrayList<String> listBooks();
    ArrayList<String> listAvailableBooks();
    ArrayList<String> listMetaData();
    BookEntity searchByCategory(String category);
    BookEntity searchByTitle(String title);
    BookEntity searchByAuthor(String author);
}

