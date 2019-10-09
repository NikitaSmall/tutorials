package com.graphqljava.tutorial.bookdetails.fetchers;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.repository.graphql.GraphQLRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.graphqljava.tutorial.bookdetails.utility.StreamUtils.filterFirst;

@Component
public class AuthorFetcher implements GraphQLFetcher {
    @Autowired
    private GraphQLRepository graphQLRepository;

    @Override
    public String fieldName() {
        return "author";
    }

    @Override
    public String typeName() {
        return "Book";
    }

    @Override
    public DataFetcher dataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return filterFirst(
                    graphQLRepository.findAll(Author.class),
                    author -> author.get("id").equals(authorId)
            );
        };
    }
}
