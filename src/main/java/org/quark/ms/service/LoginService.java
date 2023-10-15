package org.quark.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.quark.ms.exception.MsException;
import org.quark.ms.fragment.DbService;
import org.quark.ms.fragment.SessionService;
import org.quark.ms.model.request.CreateSessionRequest;

import static org.quark.ms.utils.MsContants.ErrorStatus.MISMATCH_CREDENTIAL;
import static org.quark.ms.utils.MsContants.ErrorStatus.MISSING_PERSON;

@ApplicationScoped
@Slf4j
public class LoginService {

    @Inject
    DbService dbService;
    @Inject
    SessionService service;


    public void loginService(String email, String nome, String cognome){


        log.info("LoginService started");

        var person = dbService.getPerson(email);

        if(Boolean.FALSE.equals(person.getSuccess()) || person.getPerson() != null)
            throw new MsException("Person not found",null,MISSING_PERSON);

        if(person.getPerson().getNome() != nome || person.getPerson().getCognome() != cognome)
            throw new MsException("No matching login",null,MISMATCH_CREDENTIAL);


        var session = new CreateSessionRequest();
        session.setEmail(email);
        session.setNome(nome);
        session.setScope("L1");

        var sessionResp = service.createSession(session);

        log.info("LoginService ended successfully");
    }
}
