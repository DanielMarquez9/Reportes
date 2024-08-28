package com.example.reportes_inmobiliaria.controller;

import com.example.reportes_inmobiliaria.model.ProyectoInmobiliario;
import com.example.reportes_inmobiliaria.service.ProyectoInmobiliarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoInmobiliarioController {

    @Autowired
    private ProyectoInmobiliarioService service;

    @GetMapping
    public List<ProyectoInmobiliario> getAllProyectos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoInmobiliario> getProyectoById(@PathVariable Long id) {
        Optional<ProyectoInmobiliario> proyecto = service.findById(id);
        return proyecto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProyectoInmobiliario createProyecto(@RequestBody ProyectoInmobiliario proyecto) {
        return service.save(proyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoInmobiliario> updateProyecto(@PathVariable Long id, @RequestBody ProyectoInmobiliario proyectoDetails) {
        Optional<ProyectoInmobiliario> optionalProyecto = service.findById(id);
        if (optionalProyecto.isPresent()) {
            ProyectoInmobiliario proyecto = optionalProyecto.get();
            proyecto.setNombre(proyectoDetails.getNombre());
            proyecto.setUbicacion(proyectoDetails.getUbicacion());
            proyecto.setPrecio(proyectoDetails.getPrecio());
            return ResponseEntity.ok(service.save(proyecto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
