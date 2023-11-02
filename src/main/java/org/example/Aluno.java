package org.example;

import java.util.Observable;
import java.util.Observer;

public class Aluno implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void candidatar(Bolsa bolsa) {
        bolsa.addObserver(this);
    }

    @Override
    public void update(Observable vaga, Object arg1) {
        this.ultimaNotificacao = this.nome + ", candidatura atualizada para: " + vaga.toString();
    }

    public Object getUltimaNotificação() {
        return this.ultimaNotificacao;
    }
}

