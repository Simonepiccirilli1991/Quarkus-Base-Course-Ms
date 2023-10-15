package org.quark.ms.client;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.quark.ms.model.request.AddPersonRequest;
import org.quark.ms.model.response.PersonResponse;

@ApplicationScoped
@RegisterRestClient(configKey = "db-service")
public interface PersonDbClient {


    @POST
    @Path("/person/add")
    PersonResponse addPerson(AddPersonRequest request);

    @GET
    @Path("/person/get")
    PersonResponse getPerson(@PathParam("email") String email);

    @PATCH
    @Path("/person/update")
    PersonResponse updatePerson(AddPersonRequest request);

    @DELETE
    @Path("/person/delete")
    PersonResponse deletePerson(@PathParam("email") String email);
}
