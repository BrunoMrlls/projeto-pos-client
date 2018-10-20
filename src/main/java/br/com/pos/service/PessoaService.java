package br.com.pos.service;

import java.util.List;

import br.com.pos.http.HttpPessoa;
import br.com.pos.model.Pessoa;

public class PessoaService  {

	private HttpPessoa httpPessoa = new HttpPessoa();

	public void salvar( Pessoa pessoa ) throws Exception {
		httpPessoa.salvar(pessoa);
	}

	public void excluir( Pessoa pessoa ) throws Exception {
		httpPessoa.excluir(pessoa.getId());
	}
	
	public List<Pessoa> listAll() throws Exception{
		return httpPessoa.listaPessoas();
	}
	
	public Pessoa findById(Integer id) throws Exception {
		return httpPessoa.findProdutoById(id);
	}
	
}
