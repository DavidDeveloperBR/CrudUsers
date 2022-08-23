package io.github.daviddeveloperbr.crudusers.service;

import io.github.daviddeveloperbr.crudusers.dto.UserCompleteDTO;
import io.github.daviddeveloperbr.crudusers.dto.UserDTO;
import io.github.daviddeveloperbr.crudusers.entity.User;
import io.github.daviddeveloperbr.crudusers.exception.EmailException;
import io.github.daviddeveloperbr.crudusers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository repository;

    @Transactional
    public void salvarUser(User user){
        User userFind = repository.findByEmail(user.getEmail());
        if(Objects.nonNull(userFind)){
            throw new EmailException("E-mail já existente");
        }else{
            repository.save(user);
        }

    }

    public UserCompleteDTO findUserById(Integer id) {
        User user = repository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Usuário não encontrado"));
        UserCompleteDTO dto = new UserCompleteDTO(user.getNome(), user.getSobrenome(),
                user.getEmail(), user.isAtivo());
        return dto;
    }

    @Transactional
    public void deleteUser(Integer id) {
        repository.findById(id)
                .map( user -> {
                    repository.delete(user);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuário não encontrado") );
    }

    @Override
    @Transactional
    public void atualizaUser(Integer id, String name, String email) {

        repository.findById(id).map(user -> {
            user.setNome(name);
            user.setEmail(email);
            return repository.save(user);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Usuário não encontrado"));

    }

}
