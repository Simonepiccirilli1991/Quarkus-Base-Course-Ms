package org.quark.ms.model.response;

import lombok.Data;
import org.quark.ms.model.Person;

@Data
public class PersonResponse {

    private Boolean success;
    private String msg;
    private Person person;
}
