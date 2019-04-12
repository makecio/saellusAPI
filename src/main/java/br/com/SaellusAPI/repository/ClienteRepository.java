package br.com.SaellusAPI.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import br.com.SaellusAPI.entity.Cliente;

@Component
public class ClienteRepository {
	
private final SqlSession sqlSession;
	
	public ClienteRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	public List<Cliente>buscarcnpjuserbycnpj(){
		List<Cliente>lscliente= new ArrayList<>();
		try {
			ClienteMapper clienteMapper = this.sqlSession.getMapper(ClienteMapper.class);
			 lscliente=clienteMapper.buscarclientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lscliente;
	}
	
	public Cliente buscarclientebyId(int id){
		Cliente cliente = new Cliente();
		
		try{
			 ClienteMapper clienteMapper = this.sqlSession.getMapper(ClienteMapper.class);
			 
			 cliente=clienteMapper.findclientebyid(id);
			  }
			  catch(Exception e){
				 e.printStackTrace(); 
				  
			  }
		 
		 return cliente;
	}
	
	public Cliente deletarcliente(int id) {
		
		Cliente cliente = new Cliente();
		int idcliente=0;
		
		try{
			 ClienteMapper clienteMapper = this.sqlSession.getMapper(ClienteMapper.class);
			 
			 idcliente=clienteMapper.deletarcliente(id);
			 
			 cliente=isClienteExist(id);
			  }
			  catch(Exception e){
				 e.printStackTrace(); 
				  
			  }
		 
		 return cliente;
	}
	
	public Cliente isClienteExist(int id) {
		Cliente cliente = new Cliente();
		try{
			 ClienteMapper clienteMapper = this.sqlSession.getMapper(ClienteMapper.class);
			 
			 cliente=clienteMapper.findclientebyid(id);
			  }
			  catch(Exception e){
				 e.printStackTrace(); 
				  
			  }
		 
		 return cliente;
	}
	
	public Cliente inserircliente(Cliente cliente) {
		int idcliente=0;
		try{
			 ClienteMapper clienteMapper = this.sqlSession.getMapper(ClienteMapper.class);
			 
			 idcliente=clienteMapper.inserircliente(cliente);
			 
			 cliente=isClienteExist(idcliente);
			  }
			  catch(Exception e){
				 e.printStackTrace(); 
				  
			  }
		 
		 return cliente;
		
	}
	public Cliente atualizacliente(Cliente cliente) {
		int idcliente=0;
		try{
			 ClienteMapper clienteMapper = this.sqlSession.getMapper(ClienteMapper.class);
			 
			 idcliente=clienteMapper.inserircliente(cliente);
			 
			 cliente=isClienteExist(idcliente);
			  }
			  catch(Exception e){
				 e.printStackTrace(); 
				  
			  }
		 
		 return cliente;
		
	}
	

}
