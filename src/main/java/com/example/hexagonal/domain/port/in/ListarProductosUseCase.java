package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.domain.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ListarProductosUseCase {
    List<Producto> listarTodos();
    Optional<Producto> buscarPorId(Long id);
}
