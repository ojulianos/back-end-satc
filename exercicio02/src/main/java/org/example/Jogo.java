package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Jogo {
    List<Personagem> inimigos;
    Personagem jogador;
    Random random;

    Jogo() {
        inimigos = new ArrayList<>();
        inimigos.add(new Personagem("Orc", 100, 10));
        inimigos.add(new Personagem("Goblin", 50, 5));
        inimigos.add(new Personagem("Lobo", 75, 15));
        inimigos.add(new Personagem("Cavaleiro", 200, 20));
        inimigos.add(new Personagem("Dragão", 500, 50));

        jogador = new Personagem("Steve", 100, 20);
        random = new Random();
    }

    void iniciar() {
        while (jogador.getVida() > 0 && inimigos.stream().anyMatch(inimigo -> inimigo.getVida() > 0)) {
            // Jogador ataca um inimigo aleatório
            Personagem inimigo = inimigos.get(random.nextInt(inimigos.size()));
            if (inimigo.getVida() > 0) {
                jogador.atacar(inimigo);
            }

            // Inimigos atacam o jogador
            for (Personagem inimigoAtual : inimigos) {
                if (inimigoAtual.getVida() > 0) {
                    inimigoAtual.atacar(jogador);
                }
            }
        }

        // Imprime todas as mensagens de derrota
        for (String mensagem : Personagem.getMensagensDerrota()) {
            System.out.println(mensagem);
        }

        if (jogador.getVida() <= 0) {
            System.out.println("Steve foi derrotado!");
        } else {
            System.out.println("Todos os inimigos foram derrotados!");
        }
    }
}