package br.com.SaellusAPI.clientwebservices;

import org.springframework.web.client.RestTemplate;

public class ProdutoWS {

	private RestTemplate restTemplate = new RestTemplate();
	 
	 private String getProdutos(){
		 
		 String json_produto=restTemplate.getForObject("", String.class);
	  
		 return json_produto;
		 
	 }
}
