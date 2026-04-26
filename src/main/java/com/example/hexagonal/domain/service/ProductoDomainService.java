package com.example.hexagonal.domain.service;
import com.example.hexagonal.domain.model.Producto;
import com.example.hexagonal.domain.port.in.*;
import com.example.hexagonal.domain.port.out.ProductoRepositoryPort;
import java.util.List;

public class ProductoDomainService implements CrearProductoUseCase, ListarProductosUseCase, ActualizarStockUseCase {
    private final ProductoRepositoryPort repositoryPort;

    public ProductoDomainService(ProductoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Producto crear(Producto producto) {
        return repositoryPort.guardar(producto);
    }

    @Override
    public List<Producto> listarTodos() { return repositoryPort.buscarTodos(); }

    @Override
    public java.util.Optional<Producto> buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id);
    }

    @Override
    public Producto reducirStock(Long id, int cantidad) {
        Producto p = repositoryPort.buscarPorId(id).orElseThrow();
        p.reducirStock(cantidad);
        return repositoryPort.guardar(p);
    }
}