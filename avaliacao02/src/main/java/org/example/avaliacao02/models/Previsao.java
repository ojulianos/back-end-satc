package org.example.avaliacao02.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Previsao {
    @JsonProperty("date")
    private String data;

    @JsonProperty("text")
    private String descricao;

    @JsonProperty("temperature_min")
    private double temperaturaMinima;

    @JsonProperty("temperature_max")
    private double temperaturaMaxima;

    private String cidade;
    private String estado;

    // Construtores, getters e setters
    public Previsao() {}

    public Previsao(String data, String descricao, double temperaturaMinima, double temperaturaMaxima) {
        this.data = data;
        this.descricao = descricao;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}