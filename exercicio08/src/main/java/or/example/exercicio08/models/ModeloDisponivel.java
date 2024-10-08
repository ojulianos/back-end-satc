package or.example.exercicio08.models;

import java.util.List;

public class ModeloDisponivel {
    private String nome;
    private String codigo;
    private List<Integer> anosDisponiveis;

    public ModeloDisponivel(String nome, String codigo, List<Integer> anosDisponiveis) {
        this.nome = nome;
        this.codigo = codigo;
        this.anosDisponiveis = anosDisponiveis;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Integer> getAnosDisponiveis() {
        return anosDisponiveis;
    }

    public void setAnosDisponiveis(List<Integer> anosDisponiveis) {
        this.anosDisponiveis = anosDisponiveis;
    }
}
