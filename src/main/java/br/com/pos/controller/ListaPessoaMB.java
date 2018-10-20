package br.com.pos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.pos.model.Pessoa;
import br.com.pos.service.PessoaService;
import br.com.pos.utils.FacesUtil;

@Named
@ViewScoped
public class ListaPessoaMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private PessoaService pessoaService = new PessoaService();
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private List<Pessoa> pessoaSelecionadas = new ArrayList<Pessoa>();
	
	
	@PostConstruct
	public void inicializar() {
		try {
			pessoas = pessoaService.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluirSelecionados() {
		for (Pessoa p : pessoaSelecionadas) {
			try {
				pessoaService.excluir(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pessoas.remove(p);
		}
		FacesUtil.addInfoMessage("Pessoa(s) excluída(s) com sucesso!");
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Pessoa> getPessoaSelecionadas() {
		return pessoaSelecionadas;
	}

	public void setPessoaSelecionadas(List<Pessoa> pessoaSelecionadas) {
		this.pessoaSelecionadas = pessoaSelecionadas;
	}
	
}
