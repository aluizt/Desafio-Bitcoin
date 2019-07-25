package br.com.estagio.desafiobitcoins.coin.filter.builderfilter;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuilderModel {
    private String field;
    private String content;
}
