package br.com.estagio.desafiobitcoins.exception;

import br.com.estagio.desafiobitcoins.coin.excepion.BitCoinNotFoundException;
import br.com.estagio.desafiobitcoins.coin.excepion.*;
import br.com.estagio.desafiobitcoins.coin.criteria.exception.CriteriaErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHadle {

    private static final String PT_BR = "pt-BR";
    private static final String UNEXPECTED_ERROR ="Unexpected Error";

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ResponseError> apiException(ApiException exception, HttpServletRequest request) {
         return ResponseEntity.status(exception.getErrors().get(0).getStatus())
                .body(new ResponseError(request.getRequestURI(), PT_BR, exception.getErrors()));
    }

    @ExceptionHandler(CriteriaErrorException.class)
    public ResponseEntity<ResponseError> criteriaNotFound(CriteriaErrorException e, HttpServletRequest request) {
        ApiException apiException = new ApiException(StandartError.builder()
                .message(UNEXPECTED_ERROR)
                .status(HttpStatus.BAD_REQUEST.value())
                .name(HttpStatus.BAD_REQUEST.name())
                .issue(new Issue(e))
                .suggestedUserAction("Please enter a filter. Example: Name = Money")
                .suggestedApplicationAction("")
                .build()
        );
        return ResponseEntity.status(apiException.getErrors().get(0).getStatus())
                .body(new ResponseError(request.getRequestURI(), PT_BR, apiException.getErrors()));
    }

    @ExceptionHandler(BitCoinNotFoundException.class)
    public ResponseEntity<ResponseError> bitCoinNotFound(BitCoinNotFoundException e, HttpServletRequest request) {
        ApiException apiException = new ApiException(StandartError.builder()
                .message(UNEXPECTED_ERROR)
                .status(HttpStatus.NOT_FOUND.value())
                .name(HttpStatus.NOT_FOUND.name())
                .issue(new Issue(e))
                .suggestedUserAction("Please check the ID you entered.")
                .suggestedApplicationAction("")
                .build()
        );
        return ResponseEntity.status(apiException.getErrors().get(0).getStatus())
                .body(new ResponseError(request.getRequestURI(), PT_BR, apiException.getErrors()));
    }

    @ExceptionHandler(BitCoinNameNotFoundException.class)
    public ResponseEntity<ResponseError> bitCoinNameNotFound(BitCoinNameNotFoundException e, HttpServletRequest request) {
        ApiException apiException = new ApiException(StandartError.builder()
                .message(UNEXPECTED_ERROR)
                .status(HttpStatus.NOT_FOUND.value())
                .name(HttpStatus.NOT_FOUND.name())
                .issue(new Issue(e))
                .suggestedUserAction("Please check the name you entered.")
                .suggestedApplicationAction("")
                .build()
        );
        return ResponseEntity.status(apiException.getErrors().get(0).getStatus())
                .body(new ResponseError(request.getRequestURI(), PT_BR, apiException.getErrors()));
    }

    @ExceptionHandler(ParameterNotFoundException.class)
    public ResponseEntity<ResponseError> criteriaNotFound(ParameterNotFoundException  e, HttpServletRequest request) {
        ApiException apiException = new ApiException(StandartError.builder()
                .message(UNEXPECTED_ERROR)
                .status(HttpStatus.BAD_REQUEST.value())
                .name(HttpStatus.BAD_REQUEST.name())
                .issue(new Issue(e))
                .suggestedUserAction("Please enter another valuey")
                .suggestedApplicationAction("")
                .build()
        );
        return ResponseEntity.status(apiException.getErrors().get(0).getStatus())
                .body(new ResponseError(request.getRequestURI(), PT_BR, apiException.getErrors()));
    }

    @ExceptionHandler(NumberFormatException .class)
    public ResponseEntity<ResponseError> criteriaNotFound(NumberFormatException  e, HttpServletRequest request) {
        ApiException apiException = new ApiException(StandartError.builder()
                .message(UNEXPECTED_ERROR)
                .status(HttpStatus.BAD_REQUEST.value())
                .name(HttpStatus.BAD_REQUEST.name())
                .issue(new Issue(e))
                .suggestedUserAction("Please enter a number.")
                .suggestedApplicationAction("")
                .build()
        );
        return ResponseEntity.status(apiException.getErrors().get(0).getStatus())
                .body(new ResponseError(request.getRequestURI(), PT_BR, apiException.getErrors()));
    }



}
