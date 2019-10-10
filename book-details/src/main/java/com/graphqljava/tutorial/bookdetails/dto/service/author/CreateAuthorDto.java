package com.graphqljava.tutorial.bookdetails.dto.service.author;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAuthorDto {
    public String firstName;
    public String lastName;
}
