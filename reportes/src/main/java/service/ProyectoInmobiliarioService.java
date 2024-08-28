package com.example.reportes_inmobiliaria.service;

import com.example.reportes_inmobiliaria.model.ProyectoInmobiliario;
import com.example.reportes_inmobiliaria.repository.ProyectoInmobiliarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoInmobiliarioService {

    @Autowired
    private ProyectoInmobiliarioRepository repository;

    public List<ProyectoInmobiliario> findAll() {
        return repository.findAll();
    }

    public Optional<ProyectoInmobiliario> findById(Long id) {
        return repository.findById(id);
    }

    public ProyectoInmobiliario save(ProyectoInmobiliario proyecto) {
        return repository.save(proyecto);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
