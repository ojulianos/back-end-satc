package org.example;

class PortoPequeno extends BasePorto {
    PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    void atracarBarco(Barco barco) {
        if (barco.tamanho <= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println(barco.nome + " não pode ser atracado no " + nome + " (tamanho " + barco.tamanho + " é maior que 10)");
        }
    }
}
