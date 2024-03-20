package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Sneaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @NotNull(message = "O tamanho é obrigatório")
    @Min(value = 1, message = "O tamanho deve ser válido")
    private Integer tamanho;

    @NotNull(message = "O preço é obrigatório")
    @Min(value = 1, message = "O preço deve ser maior que zero")
    private Double preço;

    @NotNull(message = "A disponibilidade é obrigatória")
    private Boolean disponibilidade;

    // Construtores
    public Sneaker() {
    }

    public Sneaker(String marca, String modelo, Integer tamanho, Double preço, Boolean disponibilidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.preço = preço;
        this.disponibilidade = disponibilidade;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
