package com.example.demo.service;

import com.example.demo.model.Sneaker;
import com.example.demo.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SneakerService {

    @Autowired
    private SneakerRepository sneakerRepository;

    public List<Sneaker> listarSneakers() {
        return sneakerRepository.findAll();
    }

    public Sneaker salvarSneaker(Sneaker sneaker) {
        return sneakerRepository.save(sneaker);
    }

    public Optional<Sneaker> buscarPorId(Long id) {
        return sneakerRepository.findById(id);
    }

}
