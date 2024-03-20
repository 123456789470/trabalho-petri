package com.example.demo.service;

import com.example.demo.model.Venda;
import com.example.demo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarTodasVendas() {
        return vendaRepository.findAll();
    }

    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Optional<Venda> buscarVendaPorId(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda atualizarVenda(Long id, Venda vendaAtualizada) {
        return vendaRepository.findById(id)
                .map(venda -> {
                    venda.setCliente(vendaAtualizada.getCliente());
                    venda.setSneaker(vendaAtualizada.getSneaker());
                    venda.setDataVenda(vendaAtualizada.getDataVenda());
                    venda.setValorVenda(vendaAtualizada.getValorVenda());
                    return vendaRepository.save(venda);
                }).orElseGet(() -> {
                    vendaAtualizada.setId(id);
                    return vendaRepository.save(vendaAtualizada);
                });
    }

    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}
