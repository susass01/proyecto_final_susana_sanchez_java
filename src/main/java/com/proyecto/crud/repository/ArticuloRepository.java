package com.proyecto.crud.repository;

import com.proyecto.crud.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    // Si necesitas consultas personalizadas las agregas aquí.
}