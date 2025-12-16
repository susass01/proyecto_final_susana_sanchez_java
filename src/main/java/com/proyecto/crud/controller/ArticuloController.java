package com.proyecto.crud.controller;

import com.exception.ResourceNotFoundException;
import com.proyecto.crud.model.Articulo;
import com.proyecto.crud.repository.ArticuloRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", "http://localhost:3000"}) // ajustar orígenes necesarios
public class ArticuloController {

  private final ArticuloRepository repo;

  public ArticuloController(ArticuloRepository repo) {
    this.repo = repo;
  }

  @GetMapping
  public List<Articulo> getAll() {
    return repo.findAll();
  }

  @GetMapping("/{id}")
  public Articulo getById(@PathVariable Long id) {
    return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artículo no encontrado con id " + id));
  }

  @PostMapping
  public ResponseEntity<Articulo> create(@RequestBody Articulo articulo) {
    // id debe ser manejado por el backend; ignoramos si viene
    articulo.setId(null);
    Articulo saved = repo.save(articulo);
    return ResponseEntity.ok(saved);
  }

  @PutMapping("/{id}")
  public Articulo update(@PathVariable Long id, @RequestBody Articulo updated) {
    Articulo existing = repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Artículo no encontrado con id " + id));
    existing.setNombre(updated.getNombre());
    existing.setPrecio(updated.getPrecio());
    return repo.save(existing);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!repo.existsById(id)) {
      throw new ResourceNotFoundException("Artículo no encontrado con id " + id);
    }
    repo.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}