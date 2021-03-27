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
        return bookRepository.findCategories();
    }

    @Override
    public ArrayList<String> listBooks() {
        return bookRepository.findBookTitles();
    }

    @Override
    public ArrayList<String> listMetaData() {
        return bookRepository.findMetaData();
    }

    @Override
    public BookEntity searchByCategory(String category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public BookEntity searchByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    @Override
    public BookEntity searchByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }
}
