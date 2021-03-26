package edu.ada.service.library.service.impl;
import edu.ada.service.library.model.entity.BookEntity;
import edu.ada.service.library.repository.BookRepository;
import edu.ada.service.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "BookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public ArrayList<String> listCategory() {
        ArrayList<String> categories = bookRepository.findCategories();
        return categories;
    }

    @Override
    public ArrayList<String> listBooks() {
        ArrayList<String> bookTitles = bookRepository.findBookTitles();
        return bookTitles;
    }

    @Override
    public ArrayList<String> listMetaData() {
        ArrayList<String> metaData = bookRepository.findMetaData();
        return metaData;
    }

    @Override
    public String searchByCategory(String category) {
        return null;
    }

    @Override
    public String searchByTitle(String title) {
        return null;
    }

    @Override
    public String searchByAuthor(String author) {
        return null;
    }
}
