package com.helbexam.library.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String genre;
    private Long author_id;
}
