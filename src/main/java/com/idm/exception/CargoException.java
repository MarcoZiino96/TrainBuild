package com.idm.exception;

public class CargoException extends  TrenoException {

    public CargoException(String sigla, String message) {
        super(sigla, message);
    }

    @Override
    public String getSiglaSuggerita() {
        return    "HCCCC ";
    }

    @Override
    public String getSuggerimento() {
        return "Per creare vagoni cargo si prega di inserire " + this.getSiglaSuggerita() + " al posto di " + getMessage();
    }
}