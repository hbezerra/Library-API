package com.libraryapi.domain.book;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record BookDTO(
        @NotBlank(message = "Title cannot be empty") String title,

        @NotNull(message = "Publication year is required")
        @Min(value = 1500, message = "Publication year must be greater than or equal to 1500")
        @Max(value = 2100, message = "Publication year must be less than or equal to 2100")
        Integer publicationYear,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
        @Digits(integer = 8, fraction = 2, message = "Price must be a valid amount with up to 8 digits and 2 decimals")
        BigDecimal price,

        @NotNull(message = "Category ID is required")
        @Positive(message = "Category ID must be a positive number")
        Long categoryId,


        @NotNull(message = "Author ID is required")
        @Positive(message = "Author ID must be a positive number")
        Long authorId
) {
}
