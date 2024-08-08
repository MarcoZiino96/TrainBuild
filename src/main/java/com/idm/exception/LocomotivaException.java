package com.idm.exception;

public class LocomotivaException extends TrenoException{

    public LocomotivaException(String sigla, String message) {
        super(sigla, message);
    }

    @Override
    public String getSiglaSuggerita() {
        return  "HPPP o HPPPH";
    }

    @Override
    public String getSuggerimento() {
        return "Per creare un treno si prega di inserire "
    + this.getSiglaSuggerita() + " al posto di " + 
     getMessage() ;
    }
}