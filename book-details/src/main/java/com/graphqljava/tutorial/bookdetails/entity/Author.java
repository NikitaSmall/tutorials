package com.graphqljava.tutorial.bookdetails.entity;

import com.graphqljava.tutorial.bookdetails.graphql.mappings.GraphQLMappable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static org.hibernate.annotations.FetchMode.SUBSELECT;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "author")
public class Author {
    @Id
    @GeneratedValue
    @GraphQLMappable
    private Integer id;

    @GraphQLMappable
    private String firstName;

    @GraphQLMappable
    private String lastName;

    @OneToMany(fetch = EAGER, mappedBy = "author") //todo: yeah
    @Fetch(value = SUBSELECT)
    private Set<Book> books = new HashSet<>();

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
