package com.graphqljava.tutorial.bookdetails.graphql.mappings;

import com.graphqljava.tutorial.bookdetails.utility.ReflectionUtils;
import com.graphqljava.tutorial.bookdetails.utility.StreamUtils;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.graphqljava.tutorial.bookdetails.utility.ReflectionUtils.*;
import static com.graphqljava.tutorial.bookdetails.utility.StreamUtils.mapList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

//todo: check if smth resembling this is provided by the graphql library
@Component
public class GraphQLMapper {
    public <T> List<Map<String, String>> toGraphQLMap(List<T> objects) {
        return mapList(objects, this::toGraphQLMap);
    }

    public <T> Map<String, String> toGraphQLMap(T obj) {
        Class objClass = obj.getClass();
        return stream(objClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(GraphQLMappable.class))
                .collect(toMap(ReflectionUtils::getFieldName, valueNameResolver(obj)));
    }

    private Function<? super Field, ? extends String> valueNameResolver(Object obj) {
        return field -> getValue(field, obj).toString();
    }
}
