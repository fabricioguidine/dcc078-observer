package org.example;

import java.util.Observable;

public class Bolsa extends Observable {
    private String curso;
    private Float valor;
    private Integer quantidade;

    public Bolsa(String curso, Float valor, Integer quantidade) {
        this.curso = curso;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public void lançarResultado() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Bolsa{" +
                "curso='" + curso + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}

