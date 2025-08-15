package com.projeto251.Projeto251.Repositorio;

import com.projeto251.Projeto251.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
}
