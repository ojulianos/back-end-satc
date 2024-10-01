package org.example;

import java.util.ArrayList;
import java.util.List;

public class MusicCloud {
    private List<Musica> musicasDisponiveis;

    public MusicCloud() {
        this.musicasDisponiveis = new ArrayList<>();
        // Adicione algumas músicas disponíveis
        musicasDisponiveis.add(new Musica("Hino do Real Paulista", "Artista A"));
        musicasDisponiveis.add(new Musica("Macarena", "Los Del Rio"));
        musicasDisponiveis.add(new Musica("Evidências", "Chitãozinho & Xororó"));
    }

    public Musica buscarMusica(String titulo) {
        for (Musica musica : musicasDisponiveis) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        return null;
    }
}
