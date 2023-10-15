package org.quark.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.quark.ms.exception.MsException;
import org.quark.ms.fragment.DbService;
import org.quark.ms.fragment.SessionService;
import org.quark.ms.model.request.CreateSessionRequest;
import org.quark.ms.model.response.LoginResponse;

import static org.quark.ms.utils.MsContants.ErrorStatus.MISMATCH_CREDENTIAL;
import static org.quark.ms.utils.MsContants.ErrorStatus.MISSING_PERSON;

@ApplicationScoped
@Slf4j
public class LoginService {

    @Inject
    DbService dbService;
    @Inject
    SessionService service;


    public LoginResponse loginService(String email, String nome, String cognome){


        log.info("LoginService started");
        // faccio get
        var person = dbService.getPerson(email);
        // se e ko o non ce la persona exception
        if(Boolean.FALSE.equals(person.getSuccess()) || person.getPerson() != null)
            throw new MsException("Person not found",null,MISSING_PERSON);
        // se non matchano exception unauthorized
        if(person.getPerson().getNome() != nome || person.getPerson().getCognome() != cognome)
            throw new MsException("No matching login",null,MISMATCH_CREDENTIAL);


        var session = new CreateSessionRequest();
        session.setEmail(email);
        session.setNome(nome);
        session.setScope("L1");

        // creo session
        service.createSession(session);

        //torno response
        var response = new LoginResponse();
        response.setAction("Go");
        response.setSuccess(true);
        log.info("LoginService ended successfully");

        return response;
    }
}
