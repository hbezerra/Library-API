package com.libraryapi.domain.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        @NotBlank(message = "Name cannot be empty") @Size(max = 100, message = "Name must have a maximum of 100 characters") String name,
        @NotBlank(message = "Description cannot be empty") @Size(max = 100, message = "Description must have a maximum of 255 characters") String description) {

}
