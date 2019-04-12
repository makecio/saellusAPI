package br.com.SaellusAPI.resources;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.SaellusAPI.entity.VirtualInfo;

@RestController
@RequestMapping("/api/pedido")
public class PedidoResources {
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@PostMapping
	public  ResponseEntity<?> inserePedido(@RequestBody VirtualInfo vinfo) {
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(vinfo));
 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	

}
