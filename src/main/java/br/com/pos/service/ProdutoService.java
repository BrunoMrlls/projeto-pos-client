package br.com.pos.service;

import java.util.List;

import br.com.pos.http.HttpProduto;
import br.com.pos.model.Produto;

public class ProdutoService{
	
	private HttpProduto httpProduto = new HttpProduto();
	
	public void salvar(Produto produto) throws Exception {
		httpProduto.salvar(produto);
	}
	
	public void excluir(Produto produto) throws Exception {
		httpProduto.excluir(produto.getId());
	}
	
	public List<Produto> listAll() throws Exception{
		return httpProduto.listaProdutos();
	}
	
	public Produto findById(Integer id) throws Exception {
		return httpProduto.findProdutoById(id);
	}
	
}
