package br.com.pos.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.pos.model.Endereco;
import br.com.pos.model.Pessoa;
import br.com.pos.service.PessoaService;

@Named
@ViewScoped
public class CadastroPessoaMB implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	private Integer idPessoa;
	
	private PessoaService pessoaService = new PessoaService();
	
	@PostConstruct
	public void inicializar() {
		if (idPessoa != null) {
			try {
				pessoa = pessoaService.findById(idPessoa);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Endereco e = new Endereco();
			pessoa.setEndereco(e);
		}
	}
	
	public String salvar() {
		try {
			pessoaService.salvar(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lista-pess.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		try {
			pessoaService.excluir(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lista-pess.xhtml?faces-redirect=true";
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public PessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
}
