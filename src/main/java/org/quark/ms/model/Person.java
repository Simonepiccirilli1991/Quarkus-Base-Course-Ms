package org.quark.ms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Person {

    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDateTime dataRegistrazione;
}
