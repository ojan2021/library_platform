package edu.ada.service.library.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class BookModel {
    private String title;
    private String category;
    private String author;
    private String publish_date;
    private String availability;
}
