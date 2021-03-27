package edu.ada.service.library.repository;


import edu.ada.service.library.model.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Query(value = "SELECT category FROM books",nativeQuery = true)
    ArrayList<String> findCategories();

    @Query(value = "SELECT title FROM books",nativeQuery = true)
    ArrayList<String> findBookTitles();

    @Query(value = "SELECT title, category, author, publish_date, availability FROM books",nativeQuery = true)
    ArrayList<String> findMetaData();


    BookEntity findAllByCategory(String category);
    BookEntity findAllByTitle(String title);
    BookEntity findAllByAuthor(String author);




}
