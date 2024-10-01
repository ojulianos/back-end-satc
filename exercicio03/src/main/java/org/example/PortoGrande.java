package org.example;

class PortoGrande extends BasePorto {
    PortoGrande(String nome) {
        super(nome);
    }

    @Override
    void atracarBarco(Barco barco) {
        if (barco.tamanho >= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println(barco.nome + " não pode ser atracado no " + nome + " (tamanho " + barco.tamanho + " é menor que 10)");
        }
    }
}
