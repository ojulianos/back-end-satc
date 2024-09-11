package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicCloud musicCloud = new MusicCloud();

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(nomePlaylist);

        while (true) {
            System.out.print("Digite o nome da música (ou 'sair' para finalizar): ");
            String nomeMusica = scanner.nextLine();
            if (nomeMusica.equalsIgnoreCase("sair")) {
                break;
            }

            Musica musica = musicCloud.buscarMusica(nomeMusica);
            if (musica != null) {
                playlist.adicionarMusica(musica);
                System.out.println("Você adicionou a música " + musica.getTitulo() + " na playlist.");
            } else {
                System.out.println("A música " + nomeMusica + " não foi encontrada no sistema.");
            }
        }

        System.out.println(playlist);
        scanner.close();
    }
}
