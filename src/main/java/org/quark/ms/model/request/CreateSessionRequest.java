package org.quark.ms.model.request;

import lombok.Data;

@Data
public class CreateSessionRequest {


    private String nome;
    private String scope;
    private String email;
}
