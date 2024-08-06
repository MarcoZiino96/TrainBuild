package com.idm.exception;

public class RistoranteException extends TrenoException {

    public RistoranteException(String sigla, String message) {
        super(sigla, message);
    }

    @Override
    public String getSiglaSuggerita() {
        return    "H"+ getMessage();
    }

    @Override
    public String getSuggerimento() {
        return "Per creare cabine ristoranti si prega di inserire un solo ristorante" + " HRPPPP " + " al posto di "  + getMessage();
    }
}