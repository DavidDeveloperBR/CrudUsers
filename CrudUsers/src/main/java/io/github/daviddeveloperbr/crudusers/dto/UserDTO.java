package io.github.daviddeveloperbr.crudusers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {

    @NotBlank(message = "Campo nome não pode ser nulo ou vazio")
    private String nome;

    @Email
    @NotBlank(message = "Campo email não pode ser nulo ou vazio")
    private String email;

}
