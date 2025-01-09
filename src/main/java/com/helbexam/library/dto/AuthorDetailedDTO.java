package com.helbexam.library.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class AuthorDetailedDTO extends AuthorDTO {
    @Getter
    @Setter
    private List<BookDTO> books;    
}