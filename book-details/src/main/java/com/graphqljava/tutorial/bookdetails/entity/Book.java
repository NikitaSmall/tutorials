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
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Author author;

    @Column(name = "author_id")
    private Integer authorId;

    public static Book noAuthorBook(String name, Integer pageCount) {
        return new Book(null, name, pageCount, null, null);
    }

    public static Book book(Integer id, String name, Integer pageCount, Author author) {
        return new Book(id, name, pageCount, author, null);
    }
}
