package com.graphqljava.tutorial.bookdetails.repository.graphql;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.graphql.mappings.GraphQLMapper;
import com.graphqljava.tutorial.bookdetails.utility.StreamUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ResolvableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.graphqljava.tutorial.bookdetails.utility.StreamUtils.filterFirst;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import static org.springframework.core.ResolvableType.forClassWithGenerics;

@Component
public class GraphQLRepository {
    @Autowired
    private List<JpaRepository> jpaRepositories;
    @Autowired
    private GraphQLMapper mapper;

    public List<Map<String, String>> findAll(Class entityClass) {
        JpaRepository repository = filterFirst(jpaRepositories, r -> jpaRepoType(entityClass).isInstance(r));
        return mapper.toGraphQLMap(repository.findAll());
    }

    private ResolvableType jpaRepoType(Class entityClass) {
        return forClassWithGenerics(JpaRepository.class, entityClass, Integer.class);
    }
}
