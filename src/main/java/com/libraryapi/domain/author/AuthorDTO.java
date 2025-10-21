package com.libraryapi.domain.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorDTO(
        @NotBlank(message = "Name cannot be empty") @Size(max = 100, message = "Name must have a maximum of 50 characters") String name,
        @Email(message = "The email provided is invalid") String email,
        @NotBlank(message = "Nacionality cannot be empty") @Size(max = 100, message = "Nacionality must have a maximum of 50 characters") String nacionality
) {
}
