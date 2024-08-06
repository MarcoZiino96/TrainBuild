package com.idm.exception;

public class StringaException extends  TrenoException{
    public StringaException(String sigla, String message) {
        super(sigla, message);
    }

    @Override
    public String getSiglaSuggerita() {
        return    "HR o HRPPPPPP";
    }

    @Override
    public String getSuggerimento() {
        return "Per creare un treno si prega di inserire una stringa di almeno 2 caratteri o di massimo 8 caratteri: "+this.getSiglaSuggerita() + " al posto di " + getMessage();
    }
}
