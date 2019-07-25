package br.com.estagio.desafiobitcoins.exception;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
public class StandartError {

    private String name;
    private String message;
    private Integer status;
    @Singular
    private List<Issue> issues;
    private String suggestedUserAction;
    private String suggestedApplicationAction;


}
