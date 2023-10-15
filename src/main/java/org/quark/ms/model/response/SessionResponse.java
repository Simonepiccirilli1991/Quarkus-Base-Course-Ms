package org.quark.ms.model.response;

import lombok.Data;

@Data
public class SessionResponse {

    private Boolean isValid;
    private String scope;
    private String email;
    private String nome;
}
