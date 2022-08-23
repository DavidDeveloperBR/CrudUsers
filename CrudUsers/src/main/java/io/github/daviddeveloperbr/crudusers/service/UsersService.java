package io.github.daviddeveloperbr.crudusers.service;

import io.github.daviddeveloperbr.crudusers.dto.UserCompleteDTO;
import io.github.daviddeveloperbr.crudusers.dto.UserDTO;
import io.github.daviddeveloperbr.crudusers.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public interface UsersService {

    void salvarUser(User usuario);
    void atualizaUser(Integer id, String name, String email);

    UserCompleteDTO findUserById(Integer id);

    void deleteUser(Integer id);



}
