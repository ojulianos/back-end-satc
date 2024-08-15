package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o primeiro nome: ");
        String primeiroNome = leitor.nextLine();

        System.out.println("Digite o segundo nome: ");
        String segundoNome = leitor.nextLine();

        Random geradorAleatorio = new Random();
        geradorAleatorio.nextInt();

        System.out.println(primeiroNome + ' ' + segundoNome);
    }
}