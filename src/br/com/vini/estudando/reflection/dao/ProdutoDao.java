package br.com.vini.estudando.reflection.dao;

import java.util.List;

import br.com.vini.estudando.reflection.modelo.Produto;

public interface ProdutoDao {
	public List<Produto> lista();
	public Produto getProduto(Integer id);
}
