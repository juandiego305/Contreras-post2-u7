package com.example.hexagonal.domain.model;
import java.math.BigDecimal;

public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    public Producto(Long id, String nombre, String descripcion, BigDecimal precio, int stock) {
        this.id = id; this.nombre = nombre; this.descripcion = descripcion;
        this.precio = precio; this.stock = stock;
    }

    // Lógica de negocio pura 
    public void reducirStock(int cantidad) {
        if (cantidad > this.stock) {
            throw new RuntimeException("Stock insuficiente. Disponible: " + this.stock);
        }
        this.stock -= cantidad;
    }

    // Getters y Setters...
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public int getStock() { return stock; }
}