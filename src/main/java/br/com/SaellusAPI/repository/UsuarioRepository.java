package br.com.SaellusAPI.repository;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import br.com.SaellusAPI.entity.Cliente;
import br.com.SaellusAPI.entity.Usuario;

@Component
public class UsuarioRepository {

	
private final SqlSession sqlSession;

public UsuarioRepository(SqlSession sqlSession) {
	this.sqlSession = sqlSession;
}

public List<Usuario>buscarusuarios(){
	List<Usuario>lstabelacampos= new ArrayList<>();
	try {
		UsuarioMapper usuarioMapper = this.sqlSession.getMapper(UsuarioMapper.class);
		lstabelacampos=usuarioMapper.buscarusuarios();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return lstabelacampos;
}


public Usuario buscarusuariobySenha(String senha){
	
	Usuario usuario = new Usuario();
	try{
		UsuarioMapper usuarioMapper = this.sqlSession.getMapper(UsuarioMapper.class);
		 
		usuario=usuarioMapper.findusuariobysenha(senha);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return usuario;
}

public Usuario buscarusuariobyEmail(String email){
	Usuario usuario = new Usuario();
	try{
		UsuarioMapper usuarioMapper = this.sqlSession.getMapper(UsuarioMapper.class);
		 
		usuario=usuarioMapper.findusuariobyemail(email);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return usuario;
}



	public Usuario buscarusuariobyId(int id){
		
		Usuario usuario = new Usuario();
		try {
			UsuarioMapper usuarioMapper = this.sqlSession.getMapper(UsuarioMapper.class);
			usuario=usuarioMapper.findusuariobyid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}




public Usuario inserirusuario(Usuario usuario) {
	int idusuario=0;
	try{
		UsuarioMapper usuarioMapper = this.sqlSession.getMapper(UsuarioMapper.class);
		 
		idusuario=usuarioMapper.inserirusuario(usuario);
		 
		usuario=isUsuarioExist(idusuario);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return usuario;
	
}

public Usuario isUsuarioExist(int id) {
	Usuario usuario = new Usuario();
	try{
		UsuarioMapper usuarioMapper = this.sqlSession.getMapper(UsuarioMapper.class);
		 
		usuario=usuarioMapper.findusuariobyid(id);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return usuario;
}

public Usuario atualizausuario(Usuario usuario) {
	int idusuario=0;
	try{
		UsuarioMapper usuarioMapper = this.sqlSession.getMapper(UsuarioMapper.class);
		 
		idusuario=usuarioMapper.inserirusuario(usuario);
		 
		usuario=isUsuarioExist(idusuario);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return usuario;
	
}

public Usuario deletarusuario(int id) {
	
	Usuario usuario = new Usuario();
	int idcliente=0;
	
	try{
		 UsuarioMapper usuarioMapper = this.sqlSession.getMapper(UsuarioMapper.class);
		 
		 idcliente=usuarioMapper.deletarusuario(id);
		 
		 usuario=isUsuarioExist(id);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return usuario;
}

}
