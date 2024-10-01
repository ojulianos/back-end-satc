package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Playlist: " + nome + "\n");
        for (Musica musica : musicas) {
            sb.append("- ").append(musica).append("\n");
        }
        return sb.toString();
    }
}
