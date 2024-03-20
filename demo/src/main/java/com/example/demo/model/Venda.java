package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Sneaker sneaker;

    private LocalDate dataVenda;
    private Double valorVenda;

    public Venda() {
    }

    public Venda(Cliente cliente, Sneaker sneaker, LocalDate dataVenda, Double valorVenda) {
        this.cliente = cliente;
        this.sneaker = sneaker;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
    }

    // Getters
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Sneaker getSneaker() { return sneaker; }
    public LocalDate getDataVenda() { return dataVenda; }
    public Double getValorVenda() { return valorVenda; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setSneaker(Sneaker sneaker) { this.sneaker = sneaker; }
    public void setDataVenda(LocalDate dataVenda) { this.dataVenda = dataVenda; }
    public void setValorVenda(Double valorVenda) { this.valorVenda = valorVenda; }
}
