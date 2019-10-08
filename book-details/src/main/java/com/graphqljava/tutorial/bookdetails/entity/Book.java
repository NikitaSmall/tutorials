package com.graphqljava.tutorial.bookdetails.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer pageCount;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
}
