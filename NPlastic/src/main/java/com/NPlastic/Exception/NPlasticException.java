package com.NPlastic.Exception;

public abstract  class NPlasticException extends  RuntimeException {

    public NPlasticException(String mensagem){
        super(mensagem);
    }
}
