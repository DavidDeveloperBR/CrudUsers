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
public class UserCompleteDTO {

    @NotBlank(message = "Campo nome não pode ser nulo ou vazio")
    private String nome;

    @NotBlank(message = "Campo sobrenome não pode ser nulo ou vazio")
    private String sobrenome;

    @Email
    @NotBlank(message = "Campo email não pode ser nulo ou vazio")
    private String email;

    @NotBlank(message = "Campo ativo não pode ser nulo ou vazio")
    private boolean ativo;

}
