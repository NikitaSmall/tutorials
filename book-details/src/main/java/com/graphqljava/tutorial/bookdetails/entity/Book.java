package com.graphqljava.tutorial.bookdetails.entity;

import com.graphqljava.tutorial.bookdetails.graphql.mappings.GraphQLMappable;
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
    @GraphQLMappable
    private Integer id;

    @GraphQLMappable
    private String name;

    @GraphQLMappable
    private Integer pageCount;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Author author;

    @GraphQLMappable
    @Column(name = "author_id")
    private Integer authorId;
}
