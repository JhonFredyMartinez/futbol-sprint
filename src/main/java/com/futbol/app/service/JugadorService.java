package com.futbol.app.service;

import com.futbol.app.entity.Jugador;
import com.futbol.app.repository.JugadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Transactional(readOnly = true)
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Jugador> findById(Long id) {
        return jugadorRepository.findById(id);
    }

    @Transactional
    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Transactional
    public void deleteById(Long id) {
        jugadorRepository.deleteById(id);
    }
}
