package online.book.store.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record CreateBookRequestDto(
        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String title,

        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        String author,

        @NotNull
        @NotBlank
        @Size(min = 1, max = 255)
        @Pattern(regexp = "^[0-9]{3}-[0-9]{10}$")
        String isbn,

        @NotNull
        @Min(0)
        BigDecimal price,

        @NotBlank
        @Size(min = 1, max = 1000)
        String description,
        String coverImage) {
}
