package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis;
    private List<Ingresso> ingressosVendidos;

    public Cinema() {
        this.filmesDisponiveis = new ArrayList<>();
        this.ingressosVendidos = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public void venderIngresso(Ingresso ingresso) throws Exception {
        // Verificar se o assento está disponível
        for (Ingresso i : ingressosVendidos) {
            if (i.getAssento().equals(ingresso.getAssento())) {
                throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
            }
        }

        // Verificar se a idade do cliente é compatível com a idade mínima do filme
        if (ingresso.getCliente().getIdade() < ingresso.getFilme().getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        ingressosVendidos.add(ingresso);
        System.out.println("Ingresso vendido com sucesso! " + ingresso.getFilme().getNome() + " - " + ingresso.getAssento() + " - " + ingresso.getCliente().getNome());
    }

    // Getters e Setters
    public List<Filme> getFilmesDisponiveis() {
        return filmesDisponiveis;
    }

    public void setFilmesDisponiveis(List<Filme> filmesDisponiveis) {
        this.filmesDisponiveis = filmesDisponiveis;
    }

    public List<Ingresso> getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(List<Ingresso> ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }
}
