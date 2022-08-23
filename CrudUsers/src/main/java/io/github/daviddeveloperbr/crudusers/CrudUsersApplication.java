package io.github.daviddeveloperbr.crudusers;

import io.github.daviddeveloperbr.crudusers.entity.User;
import io.github.daviddeveloperbr.crudusers.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudUsersApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired UsersService usersService){
        return args -> {
            User u1 = new User(1,"davirodrigues","teste", "David", "Rodrigues", "david@mail.com",true);
            usersService.salvarUser(u1);
        };
    }


}
