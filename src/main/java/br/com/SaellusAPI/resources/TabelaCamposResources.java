package br.com.SaellusAPI.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.SaellusAPI.entity.TabelaCampos;
import br.com.SaellusAPI.repository.TabelaCamposRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/campostabela")
public class TabelaCamposResources {
	
	@Autowired
	TabelaCamposRepository tabelacamposRepository;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	public ResponseEntity<List<TabelaCampos>> getTabelaCamposs() {
		
		List<TabelaCampos> lsTabelaCampos = tabelacamposRepository.buscartabelacampos();
        if (lsTabelaCampos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TabelaCampos>>(lsTabelaCampos, HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getTabelaCampos(@PathVariable("id") int id) {
		
		TabelaCampos TabelaCampos = tabelacamposRepository.buscartabelacampobyClienteId(id);
	        if (TabelaCampos == null) {
	            
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<TabelaCampos>(TabelaCampos, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public  ResponseEntity<?> insereTabelaCampos(@RequestBody TabelaCampos TabelaCampos, UriComponentsBuilder ucBuilder) {
		
		if (tabelacamposRepository.isTabelaCamposExist(TabelaCampos.getId()) != null) {
            
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
		tabelacamposRepository.inserirtabelacampos(TabelaCampos);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(TabelaCampos.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{nameTabela}/{idcliente}")
	public ResponseEntity<List<TabelaCampos>> getTabelaCamposbydescriandcli(@PathVariable("nameTabela") String nameTabela,@PathVariable("idcliente") int idcliente) {
		
		List<TabelaCampos> lsTabelaCampos = tabelacamposRepository.buscartabelabynameandcliente(nameTabela,idcliente);
        if (lsTabelaCampos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TabelaCampos>>(lsTabelaCampos, HttpStatus.OK);
		
	}
		
	
	/*
	@SuppressWarnings("rawtypes")
	@DeleteMapping
	public  ResponseEntity<?> deleteTabelaCampos(@PathVariable("id") int id) {
		
		TabelaCampos TabelaCampos = tabelacamposRepository.isTabelaCamposExist(id);
        if (TabelaCampos == null) {
            
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        tabelacamposRepository.deletarTabelaCampos(id);
        return new ResponseEntity<TabelaCampos>(HttpStatus.NO_CONTENT);
	}
	
	
	@SuppressWarnings("rawtypes")
	@PutMapping
	public  ResponseEntity<?> updateTabelaCampos(@RequestBody TabelaCampos TabelaCampos) {
		
		TabelaCampos currentTabelaCampos = tabelacamposRepository.isTabelaCamposExist(TabelaCampos.getId());
		 
	        if (currentTabelaCampos == null) {
	            
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
	 
	        return new ResponseEntity<TabelaCampos>( tabelacamposRepository.atualizaTabelaCampos(TabelaCampos), HttpStatus.OK);
	}
	*/

}
