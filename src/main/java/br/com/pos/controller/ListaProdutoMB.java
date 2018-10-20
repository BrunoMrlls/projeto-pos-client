package br.com.pos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.pos.model.Produto;
import br.com.pos.service.ProdutoService;
import br.com.pos.utils.FacesUtil;


@Named
@ViewScoped
public class ListaProdutoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ProdutoService produtoService = new ProdutoService(); 
	
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Produto> produtosSelecionados = new ArrayList<Produto>();
	
	@PostConstruct
	public void inicializar() {
		try {
			produtos = produtoService.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluirSelecionado() {
		for (Produto p: produtosSelecionados) {
			try {
				produtoService.excluir(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			produtos.remove(p);
		}
		FacesUtil.addInfoMessage("Produto(s) excluído(s) com sucesso!");
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutosSelecionados() {
		return produtosSelecionados;
	}

	public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}

}
