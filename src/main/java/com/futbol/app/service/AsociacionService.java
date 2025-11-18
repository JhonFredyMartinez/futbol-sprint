package com.futbol.app.service;

import com.futbol.app.entity.Asociacion;
import com.futbol.app.repository.AsociacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AsociacionService {

    private final AsociacionRepository asociacionRepository;

    public AsociacionService(AsociacionRepository asociacionRepository) {
        this.asociacionRepository = asociacionRepository;
    }

    @Transactional(readOnly = true)
    public List<Asociacion> findAll() {
        return asociacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Asociacion> findById(Long id) {
        return asociacionRepository.findById(id);
    }

    @Transactional
    public Asociacion save(Asociacion asociacion) {
        return asociacionRepository.save(asociacion);
    }

    @Transactional
    public void deleteById(Long id) {
        asociacionRepository.deleteById(id);
    }
}
