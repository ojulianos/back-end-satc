package org.example;

class Personagem {
    String nome;
    int vida;
    int ataque;

    Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(this.nome + " foi derrotado!");
        }
    }

    void atacar(Personagem alvo) {
        if (alvo.vida > 0) {
            alvo.receberDano(this.ataque);
        } else {
            System.out.println("O ataque falhou! " + alvo.nome + " já está derrotado.");
        }
    }
}
