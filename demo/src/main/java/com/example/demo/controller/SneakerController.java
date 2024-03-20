package com.example.demo.controller;

import com.example.demo.model.Sneaker;
import com.example.demo.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sneakers")
public class SneakerController {

    @Autowired
    private SneakerService sneakerService;

    @GetMapping
    public List<Sneaker> listarSneakers() {
        return sneakerService.listarSneakers();
    }

    @PostMapping
    public Sneaker adicionarSneaker(@RequestBody Sneaker sneaker) {
        return sneakerService.salvarSneaker(sneaker);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> buscarSneakerPorId(@PathVariable Long id) {
        return sneakerService.buscarPorId(id)
                .map(sneaker -> ResponseEntity.ok(sneaker))
                .orElse(ResponseEntity.notFound().build());
    }

}
