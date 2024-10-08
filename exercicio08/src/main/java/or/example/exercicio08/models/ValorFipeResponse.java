package or.example.exercicio08.models;

public class ValorFipeResponse {
    private String valor;
    private String mes;

    public ValorFipeResponse(String valor, String mes) {
        this.valor = valor;
        this.mes = mes;
    }

    // Getters e Setters
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
