package org.example;

import java.util.ArrayList;
import java.util.List;

class BasePorto {
    String nome;
    List<Barco> barcosAtracados;

    BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    void atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        System.out.println(barco.nome + " atracado no " + nome);
    }

    void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
        System.out.println(barco.nome + " desatracado do " + nome);
    }
}
