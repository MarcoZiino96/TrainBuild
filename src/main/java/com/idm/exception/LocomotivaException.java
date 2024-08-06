package com.idm.exception;

public class LocomotivaException extends TrenoException{

    public LocomotivaException(String sigla, String message) {
        super(sigla, message);
    }

    @Override
    public String getSiglaSuggerita() {
        return  "H" + super.getMessage() + " o " + "H" + super.getMessage() + "H";
    }

    @Override
    public String getSuggerimento() {
        return "Per creare un treno si prega di inserire " + this.getSiglaSuggerita() + " al posto di " + getMessage();
    }
}