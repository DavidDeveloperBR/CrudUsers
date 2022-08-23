package io.github.daviddeveloperbr.crudusers.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Campo usuario não pode ser nulo ou vazio")
    @Column(name = "usuario", length = 100)
    private String usuario;

    @NotBlank(message = "Campo senha não pode ser nulo ou vazio")
    @Column(name = "senha")
    private String senha;

    @NotBlank(message = "Campo nome não pode ser nulo ou vazio")
    @Column(name = "nome", length = 100)
    private String nome;

    @NotBlank(message = "Campo sobrenome não pode ser nulo ou vazio")
    @Column(name = "sobrenome", length = 100)
    private String sobrenome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "Campo email não pode ser nulo ou vazio")
    @Column(name = "email", length = 100, unique=true)
    private String email;

    @Column(name = "ativo", length = 100)
    private boolean ativo;

}
