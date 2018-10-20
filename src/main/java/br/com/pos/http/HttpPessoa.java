package br.com.pos.http;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.pos.model.Pessoa;
import br.com.pos.utils.RequisicoesHttp;

public class HttpPessoa {
	
	private final static String URL_WS = "http://localhost:8080/projeto-pos/rest/pessoa";
	private final static String LISTAR_TODAS_PESSOAS = "/listar";
	private final static String BUSCAR_PESSOA = "/find/";
	private final static String EXCLUIR_PESSOA = "/excluir/";
	private final static String INSERIR_PESSOA = "/inserir";
	private final static String ALTERAR_PESSOA = "/alterar";
	
	public List<Pessoa> listaPessoas() throws Exception{
		String json = RequisicoesHttp.sendGet(URL_WS+LISTAR_TODAS_PESSOAS);
		
		Gson gson = new Gson();
        Type datasetListType = new TypeToken<Collection<Pessoa>>() {}.getType();
        List<Pessoa> pessoas = gson.fromJson(json, datasetListType);
        for (Pessoa p : pessoas) {
			System.out.println(p.getNome());
			System.out.println(p.getCpfCnpj());
			System.out.println("---");
		}
        
		return pessoas;
	}

	public Pessoa findProdutoById(Integer id) throws Exception {
		String json = RequisicoesHttp.sendGet(URL_WS+BUSCAR_PESSOA+id);
		
		Gson gson = new Gson();
		return gson.fromJson(json, Pessoa.class);
	}

	public void excluir(Integer id) throws Exception {
		RequisicoesHttp.sendDelete(URL_WS+EXCLUIR_PESSOA, id);
	}

	public void salvar(Pessoa p) throws Exception {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    System.out.println(gson.toJson(p));
	    String json = gson.toJson(p);
	    
	    if (p.isInclusao()) {
	    	RequisicoesHttp.sendPost(URL_WS+INSERIR_PESSOA, json);
	    }else {
	    	RequisicoesHttp.sendPut(URL_WS+ALTERAR_PESSOA, json);
	    }
	}
	
}
