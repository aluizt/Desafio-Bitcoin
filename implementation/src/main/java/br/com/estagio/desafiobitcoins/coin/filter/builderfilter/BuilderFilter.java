package br.com.estagio.desafiobitcoins.coin.filter.builderfilter;

import br.com.estagio.desafiobitcoins.coin.criteria.*;
import br.com.estagio.desafiobitcoins.coin.excepion.*;
import br.com.estagio.desafiobitcoins.coin.filter.enumfilter.*;
import br.com.estagio.desafiobitcoins.coin.filter.filter.SimpleFilter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class BuilderFilter {

    public SimpleFilter findField(ImplCriteria implCriteria){
        EnumFilter enumFilter= EnumFilter.valueOf(buildeFilter(implCriteria).getField().toUpperCase());
        return enumFilter.getSimpleFilter();
    }

    public String findContent(ImplCriteria implCriteria){
        return buildeFilter(implCriteria).getContent();
    }

    private BuilderModel buildeFilter(ImplCriteria implCriteria)  {
        Class<?> classe = implCriteria.getClass();
        Field[] campos = classe.getDeclaredFields();

        String nameField="";
        Object contentField=null;

        for(Field campo : campos){
            nameField=campo.getName();
            campo.setAccessible(true);
            try {
                contentField=campo.get(implCriteria);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(contentField!=null) {
                return BuilderModel.builder()
                        .field(nameField)
                        .content(contentField.toString())
                        .build();
            }
        }

        throw new ParameterNotFoundException("Invalid Filter");
    }
}
