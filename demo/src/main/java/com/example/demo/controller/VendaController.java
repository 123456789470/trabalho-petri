package com.example.demo.controller;

import com.example.demo.model.Venda;
import com.example.demo.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listarVendas() {
        return vendaService.listarTodasVendas();
    }

    @PostMapping
    public Venda adicionarVenda(@RequestBody Venda venda) {
        return vendaService.salvarVenda(venda);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarVendaPorId(@PathVariable Long id) {
        return vendaService.buscarVendaPorId(id)
                .map(venda -> ResponseEntity.ok(venda))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Venda atualizarVenda(@PathVariable Long id, @RequestBody Venda venda) {
        return vendaService.atualizarVenda(id, venda);
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
    }
}
