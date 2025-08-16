package com.projeto251.Projeto251.Controle;

import com.projeto251.Projeto251.Model.Produto;
import com.projeto251.Projeto251.Repositorio.ProdutoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("produtos")
@CrossOrigin(origins = "*")

public class ProdutoControle {
    private ProdutoRepositorio acaoProduto;

    public ProdutoControle(ProdutoRepositorio acaoProduto ) {
        this.acaoProduto = acaoProduto;
    }

    @PostMapping("/cadastrar")
    public void salvar(@RequestBody Produto produto){
        System.out.println("Nome Produto: "+ produto.getNome());
        System.out.println("Descrição  Produto: "+ produto.getDescricao());
        System.out.println("Preço Produto: "+ produto.getPreco());
        acaoProduto.save(produto);
    }

    @GetMapping("/pesquisar/{id}")
    public Produto obterProdutoId(@PathVariable("id") Long id){
        return acaoProduto.findById(id).orElse(null);
    }

    @GetMapping("/mostratudo")
    public List<Produto> obterProdutos(){
        return acaoProduto.findAll();
    }

    @PutMapping("/alterar/{id}")
    public void alterar(@PathVariable("id") Long id, @RequestBody Produto prod){
        prod.setId(id);
        acaoProduto.save(prod);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarId(@PathVariable("id") Long id){
        acaoProduto.deleteById(id);
    }


}
