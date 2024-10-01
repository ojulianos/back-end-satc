package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] suggests = { "Homens de Preto", "Arrival", "Shrek", "Gladiador" };
        String[] questions = { "Pergunta 1: Que ambientação você prefere?", "Pergunta 2: Que gênero você prefere?" };
        String[][] options = { {"  1. Sci-fi", "  2. Medieval"}, {"  1. Comédia", "  2. Drama"} };
        String response;

        while(true) {
            response = "";
            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i]);
                for (int j = 0; j < options[i].length; j++) {
                    System.out.println(options[i][j]);
                }
                response += scan.nextLine();
            }

            if (!response.matches("(11|12|21|22)")) {
                System.out.println("Resposta inválida " + response);
                return;
            }

            switch (response) {
                case "11": response = suggests[0]; break;
                case "12": response = suggests[1]; break;
                case "21": response = suggests[2]; break;
                case "22": response = suggests[3]; break;
            }

            System.out.println("Recomendação: " + response);
            System.out.println("--------------------------------------------------");
        }

    }
}