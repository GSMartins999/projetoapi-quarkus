package dev.java10xcurso.controller;

import java.util.UUID;

import dev.java10xcurso.domain.Users;
import dev.java10xcurso.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Transactional
    // Não precisa ser utilizado no GET, mas é recomendado para manter a
    // consistência e garantir que as operações sejam atômicas.
    public Response findAllUsers(
            @QueryParam("page") @jakarta.ws.rs.DefaultValue("0") Integer page,
            @QueryParam("pageSize") @jakarta.ws.rs.DefaultValue("10") Integer pageSize) {
        var users = userService.findAllUsers(page, pageSize);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response findUserById (@PathParam("id") UUID userId){
        return Response.ok(userService.findUserById(userId)).build();
    }


    @POST
    @Path("/create")
    @Transactional
    public Response createUser(Users users) {
        return Response.ok(userService.createUser(users)).build();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") UUID userId, Users users) {
        return Response.ok(userService.updateUser(userId, users)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") UUID userId){
        userService.deleteUser(userId);
        return Response.ok("User removed").build();
    }
}
