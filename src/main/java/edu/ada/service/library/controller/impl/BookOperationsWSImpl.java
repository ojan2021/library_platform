package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.BookOperationsWS;
import edu.ada.service.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/search")
public class BookOperationsWSImpl implements BookOperationsWS {



    @Autowired
    @Qualifier(value = "BookServiceImpl")
    private BookService bookService;

    @Override
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity listCategory() {
        ArrayList<String> categories = bookService.listCategory();
        String temp = "Categories:\n";
        for (String i:categories) {
            temp += i +"\n";
        }
        return ResponseEntity.ok(temp);
    }

    @Override
    @RequestMapping(value = "/book_titles", method = RequestMethod.GET)
    public ResponseEntity listBooks() {
        ArrayList<String> bookTitles = bookService.listBooks();
        String temp = "Books:\n";
        for (String i:bookTitles) {
            temp += i +"\n";
        }
        return ResponseEntity.ok(temp);
    }


    @Override
    @RequestMapping(value = "/metadata", method = RequestMethod.GET)
    public ResponseEntity listMetaData() {
        ArrayList<String> metaData = bookService.listMetaData();
        String temp = "Meta Data:\n";
        for (String i:metaData) {
            temp += i +"\n";
        }
        return ResponseEntity.ok(temp);
    }

    @Override
    @RequestMapping(value = "/sbc", method = RequestMethod.GET)
    public ResponseEntity searchByCategory(
            @RequestHeader("category") String category) {
        return ResponseEntity.ok(bookService.searchByCategory(category));
    }

    @Override
    @RequestMapping(value = "/sbt", method = RequestMethod.GET)
    public ResponseEntity searchByTitle(
            @RequestHeader("title") String title) {
        return ResponseEntity.ok(bookService.searchByTitle(title));
    }

    @Override
    @RequestMapping(value = "/sba", method = RequestMethod.GET)
    public ResponseEntity searchByAuthor(
            @RequestHeader("author") String author) {
        return ResponseEntity.ok(bookService.searchByAuthor(author));
    }
}
