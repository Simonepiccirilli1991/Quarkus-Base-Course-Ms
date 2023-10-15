package org.quark.ms.model.request;

import lombok.Data;


public record LoginRequest(String email,String nome,String cognome) {
}
