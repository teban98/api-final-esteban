package com.example.demo.exeption;

public class NoexisteEsxception extends RuntimeException {
    public NoexisteEsxception(String mensaje){
        super(mensaje);
    }
}
