package org.quark.ms.model.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddPersonRequest {

    @NonNull
    private String nome;
    @NonNull
    private String cognome;
    @NonNull
    private String email;
    private String numero;
}
