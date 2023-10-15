package org.quark.ms.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.quark.ms.fragment.DbService;
import org.quark.ms.model.request.AddPersonRequest;
import org.quark.ms.model.request.LoginRequest;
import org.quark.ms.service.LoginService;

@Path("api/v1/ms")
public class MsController {

    @Inject
    DbService dbService;
    @Inject
    LoginService loginService;


    @Path("/add/person")
    public Response addPerson(AddPersonRequest request){
        return Response.ok(dbService.addPerson(request)).build();
    }

    @Path("/login")
    public Response login(LoginRequest request){
        return Response.ok(loginService.loginService(request.email(), request.nome(), request.cognome())).build();
    }
}
