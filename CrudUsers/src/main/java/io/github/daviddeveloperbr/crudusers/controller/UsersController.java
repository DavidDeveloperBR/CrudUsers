package io.github.daviddeveloperbr.crudusers.controller;

import io.github.daviddeveloperbr.crudusers.dto.UserCompleteDTO;
import io.github.daviddeveloperbr.crudusers.dto.UserDTO;
import io.github.daviddeveloperbr.crudusers.entity.User;
import io.github.daviddeveloperbr.crudusers.exception.EmailException;
import io.github.daviddeveloperbr.crudusers.service.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Usuário cadastrado com sucesso")
    public void salvar(@RequestBody @Valid User user){
        try{
            usersService.salvarUser(user);
        }catch (EmailException ex){
            throw  new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }
    }

    @GetMapping("{id}")
    public UserCompleteDTO getUserById(@PathVariable Integer id){
        return usersService.findUserById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser( @PathVariable Integer id ){
        usersService.deleteUser(id);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Integer id, @RequestBody UserDTO dto){
        usersService.atualizaUser(id, dto.getNome(), dto.getEmail());
    }

}
