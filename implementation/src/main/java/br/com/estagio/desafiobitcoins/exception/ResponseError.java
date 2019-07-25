package br.com.estagio.desafiobitcoins.exception;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    private String namespace;
    private String language;
    @Singular
    private List<StandartError> errors;



}
