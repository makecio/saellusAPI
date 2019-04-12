package br.com.SaellusAPI.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.SaellusAPI.entity.Cliente;
import br.com.SaellusAPI.repository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResources {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	public ResponseEntity<List<Cliente>> getclientes() {
		
		List<Cliente> lscliente = clienteRepository.buscarcnpjuserbycnpj();
        if (lscliente.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Cliente>>(lscliente, HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getcliente(@PathVariable("id") int id) {
		
		Cliente cliente = clienteRepository.buscarclientebyId(id);
	        if (cliente == null) {
	            
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public  ResponseEntity<?> inserecliente(@RequestBody Cliente cliente, UriComponentsBuilder ucBuilder) {
		
		if (clienteRepository.isClienteExist(cliente.getId()) != null) {
            
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
		clienteRepository.inserircliente(cliente);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(cliente.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping
	public  ResponseEntity<?> deletecliente(@PathVariable("id") int id) {
		
		Cliente cliente = clienteRepository.buscarclientebyId(id);
        if (cliente == null) {
            
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        clienteRepository.deletarcliente(id);
        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}
	
	
	@SuppressWarnings("rawtypes")
	@PutMapping
	public  ResponseEntity<?> updatecliente(@RequestBody Cliente cliente) {
		
		Cliente currentCliente = clienteRepository.buscarclientebyId(cliente.getId());
		 
	        if (currentCliente == null) {
	            
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
	 
	        return new ResponseEntity<Cliente>( clienteRepository.atualizacliente(cliente), HttpStatus.OK);
	}
	
	

}
