package br.com.pos.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.pos.model.Produto;
import br.com.pos.service.ProdutoService;

@Named
@ViewScoped
public class CadastroProdutoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	private Integer idProduto;
	private ProdutoService produtoService = new ProdutoService();
	
	@PostConstruct
	public void inicializar() {
		if (idProduto != null ) {
			try {
				produto = produtoService.findById(idProduto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String salvar() {
		try {
			produtoService.salvar(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lista-prod.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		try {
			produtoService.excluir(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  "lista-prod.xhtml?faces-redirect=true";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
}
