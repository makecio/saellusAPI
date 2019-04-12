package br.com.SaellusAPI.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.SaellusAPI.entity.Usuario;
import br.com.SaellusAPI.repository.UsuarioRepository;

import br.com.SaellusAPI.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioResources {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios() {
		
		List<Usuario> lsUsuario = usuarioRepository.buscarusuarios();
        if (lsUsuario.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Usuario>>(lsUsuario, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable("id") int id) {
		
		Usuario Usuario = usuarioRepository.buscarusuariobyId(id);
	        if (Usuario == null) {
	            
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "autenticaUsuario/{email}/{senha}" ,method = RequestMethod.GET)
	public ResponseEntity<?> autenticaUsuario(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		
		Usuario Usuario = usuarioRepository.buscarusuariobyEmail(email);
	        if (Usuario == null) {
	            
	            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	        }else{
	        	
			        	if(!Usuario.getSenha().trim().equals(senha)){
			        		 return new ResponseEntity(HttpStatus.FORBIDDEN);
			        	}
	        }     
	        return new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public  ResponseEntity<?> insereUsuario(@RequestBody Usuario Usuario, UriComponentsBuilder ucBuilder) {
		
		if (usuarioRepository.isUsuarioExist(Usuario.getId()) != null) {
            
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
		usuarioRepository.inserirusuario(Usuario);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(Usuario.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping
	public  ResponseEntity<?> deleteUsuario(@PathVariable("id") int id) {
		
		Usuario Usuario = usuarioRepository.buscarusuariobyId(id);
        if (Usuario == null) {
            
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        usuarioRepository.deletarusuario(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}
	
	
	@SuppressWarnings("rawtypes")
	@PutMapping
	public  ResponseEntity<?> updateUsuario(@RequestBody Usuario Usuario) {
		
		Usuario currentUsuario = usuarioRepository.buscarusuariobyId(Usuario.getId());
		 
	        if (currentUsuario == null) {
	            
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
	 
	        return new ResponseEntity<Usuario>( usuarioRepository.atualizausuario(Usuario), HttpStatus.OK);
	}
	
	


}
