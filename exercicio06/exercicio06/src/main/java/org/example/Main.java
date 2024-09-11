package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        // Adicionar filmes disponíveis
        cinema.adicionarFilme(new Filme("Homem Aranha", 20.0, 12));
        cinema.adicionarFilme(new Filme("Vingadores", 25.0, 12));
        cinema.adicionarFilme(new Filme("Toy Story", 15.0, 0));
        cinema.adicionarFilme(new Filme("Coringa", 30.0, 18));
        cinema.adicionarFilme(new Filme("Frozen", 20.0, 0));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();

                Filme filmeEscolhido = null;
                for (Filme filme : cinema.getFilmesDisponiveis()) {
                    if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                        filmeEscolhido = filme;
                        break;
                    }
                }

                if (filmeEscolhido == null) {
                    System.out.println("Filme não encontrado!");
                    continue;
                }

                System.out.println("Qual assento você deseja?");
                String assento = scanner.nextLine();

                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();

                System.out.println("Qual a sua idade?");
                int idadeCliente = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);
                Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);

                cinema.venderIngresso(ingresso);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

