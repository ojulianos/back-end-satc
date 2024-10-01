package org.example;

import java.util.ArrayList;
import java.util.List;

public class Personagem {
    private String nome;
    private int vida;
    private int ataque;
    private static List<String> mensagensDerrota = new ArrayList<>();

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0;
            mensagensDerrota.add(this.nome + " foi derrotado!");
        }
    }

    public void atacar(Personagem alvo) {
        if (alvo.vida > 0) {
            alvo.receberDano(this.ataque);
        } else {
            System.out.println("O ataque falhou! " + alvo.nome + " já está derrotado.");
        }
    }

    public int getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }

    public static List<String> getMensagensDerrota() {
        return mensagensDerrota;
    }
}