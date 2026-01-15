package online.book.store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import online.book.store.annotation.FieldMatch;

@FieldMatch(
        first = "password",
        second = "repeatPassword",
        message = "Password and repeat password must be the same"
)
public record UserRegistrationRequestDto(

        @Email
        @NotNull
        @NotBlank
        String email,

        @NotBlank
        @NotNull
        @Size(min = 8, max = 20)
        String password,

        @NotBlank
        @NotNull
        @Size(min = 8, max = 20)
        String repeatPassword,

        @NotNull
        @NotBlank
        String firstName,

        @NotNull
        @NotBlank
        String lastName,
        String shippingAddress
) {
}
