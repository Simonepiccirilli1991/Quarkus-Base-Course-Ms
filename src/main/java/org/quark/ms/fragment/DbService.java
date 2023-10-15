package org.quark.ms.fragment;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.quark.ms.client.PersonDbClient;
import org.quark.ms.exception.MsException;
import org.quark.ms.model.request.AddPersonRequest;
import org.quark.ms.model.response.PersonResponse;

import static org.quark.ms.utils.MsContants.ErrorStatus.GENERIC_ERROR;

@ApplicationScoped
@Slf4j
public class DbService {

    @Inject
    @RestClient
    PersonDbClient personDbClient;


    public PersonResponse addPerson(AddPersonRequest request){

        log.info("AddPerson started");
        try{
            var resp = personDbClient.addPerson(request);
            log.info("AddPerson ended successfully");
            return resp;
        }catch (Exception e){
            log.error("Error on addPerson with error: {}",e);
            throw new MsException("Error on addPerson",e,GENERIC_ERROR);
        }
    }


    public PersonResponse getPerson(String email){

        log.info("GetPerson started");
        try{
            var resp = personDbClient.getPerson(email);
            log.info("GetPerson ended successfully");
            return resp;
        }catch (Exception e){
            log.error("Error on getPerson with error: {}",e);
            throw new MsException("Error on getPerson",e,GENERIC_ERROR);
        }
    }
}
