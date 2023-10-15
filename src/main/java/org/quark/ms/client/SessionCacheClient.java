package org.quark.ms.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.quark.ms.model.request.CreateSessionRequest;
import org.quark.ms.model.response.SessionResponse;

@ApplicationScoped
@RegisterRestClient(configKey = "cache-service")
public interface SessionCacheClient {


    @POST
    @Path("session/create")
    SessionResponse createSession(CreateSessionRequest request);


    @GET
    @Path("session/get")
    SessionResponse getSession(@PathParam("email") String email);
}
