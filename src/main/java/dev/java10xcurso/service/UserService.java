package dev.java10xcurso.service;

import java.util.List;
import java.util.UUID;
import dev.java10xcurso.domain.Users;
import dev.java10xcurso.exceptions.UserNotFoundException;
import io.vertx.mutiny.ext.auth.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {

    public Users createUser(Users users){
        users.persist();
        return users;
    }

    public List<Users> findAllUsers(Integer page, Integer pageSize){
        return Users.findAll()
        .page(page, pageSize)
        .list();
    }

    public Users findUserById(UUID userId) {
        return (Users) Users.findByIdOptional(userId)
            .orElseThrow(UserNotFoundException::new);
    }

    public Users updateUser(UUID userId, Users users){
        //Verifica se o usuário existe
        var user = findUserById(userId);

        user.username = users.username;
        user.email = users.email;
        Users.persist(user);
        return user;

    }

    public void deleteUser(UUID userId){
        var user = findUserById(userId);
        Users.deleteById(user.id);
    }
}
