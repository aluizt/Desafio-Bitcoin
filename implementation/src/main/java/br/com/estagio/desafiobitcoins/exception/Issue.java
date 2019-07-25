package br.com.estagio.desafiobitcoins.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {

    private String id;
    private String message;

    public Issue(Exception e) {
        this.id = e.toString();
        this.message = e.getMessage();
    }
}
