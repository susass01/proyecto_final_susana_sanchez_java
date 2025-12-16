package com.proyecto.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos")
public class Articulo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private Double precio;

  // constructores
  public Articulo() {}

  public Articulo(String nombre, Double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }

  // getters y setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  public Double getPrecio() { return precio; }
  public void setPrecio(Double precio) { this.precio = precio; }
}