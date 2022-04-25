package mk.ukim.finki.lab2_emt.model.dto;

import lombok.Data;
import mk.ukim.finki.lab2_emt.model.Author;
import mk.ukim.finki.lab2_emt.model.Category;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
public class BookDto {

    private String name;

    private Category category;

    private Author author;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
