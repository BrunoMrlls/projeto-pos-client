package br.com.pos.http;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.pos.model.Produto;
import br.com.pos.utils.RequisicoesHttp;

public class HttpProduto {
	
	private final static String URL_WS = "http://localhost:8080/projeto-pos/rest/produto";
	private final static String LISTAR_TODOS_PRODUTOS = "/listar";
	private final static String BUSCAR_PRODUTO = "/find/";
	private final static String EXCLUIR_PRODUTO = "/excluir/";
	private final static String INSERIR_PRODUTO = "/inserir";
	private final static String ALTERAR_PRODUTO = "/alterar";
	
	public List<Produto> listaProdutos() throws Exception{
		String json = RequisicoesHttp.sendGet(URL_WS+LISTAR_TODOS_PRODUTOS);
		
		Gson gson = new Gson();
        Type datasetListType = new TypeToken<Collection<Produto>>() {}.getType();
		return gson.fromJson(json, datasetListType);
	}

	public Produto findProdutoById(Integer id) throws Exception {
		String json = RequisicoesHttp.sendGet(URL_WS+BUSCAR_PRODUTO+id);
		
		Gson gson = new Gson();
		return gson.fromJson(json, Produto.class);
	}

	public void excluir(Integer id) throws Exception {
		RequisicoesHttp.sendDelete(URL_WS+EXCLUIR_PRODUTO, id);		
	}

	public void salvar(Produto p) throws Exception {
	    GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    System.out.println(gson.toJson(p));
	    String json = gson.toJson(p);
	    
	    if ( p.isInclusao() ) {
	    	RequisicoesHttp.sendPost(URL_WS+INSERIR_PRODUTO, json);
	    } else { 
	    	RequisicoesHttp.sendPut(URL_WS+ALTERAR_PRODUTO, json);
	    }
	    
	}
	
}

