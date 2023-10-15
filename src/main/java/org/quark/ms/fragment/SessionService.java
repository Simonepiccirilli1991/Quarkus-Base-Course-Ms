package org.quark.ms.fragment;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.quark.ms.client.SessionCacheClient;
import org.quark.ms.exception.MsException;
import org.quark.ms.model.request.CreateSessionRequest;
import org.quark.ms.model.response.SessionResponse;

import static org.quark.ms.utils.MsContants.ErrorStatus.GENERIC_ERROR;

@ApplicationScoped
@Slf4j
public class SessionService {

    @Inject
    @RestClient
    SessionCacheClient cacheClient;


    public SessionResponse createSession(CreateSessionRequest request){

        log.info("CreateSession started with request: {}",request);
        try{

            var resp = cacheClient.createSession(request);
            log.info("CreateSession endedn successfully");
            return resp;
        }catch (Exception e){
        log.error("Erro on CreateSession with error: {}",e);
        throw new MsException("Error on createSession",e,GENERIC_ERROR);
        }
    }
}
