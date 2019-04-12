package br.com.SaellusAPI.repository;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import br.com.SaellusAPI.entity.Cliente;
import br.com.SaellusAPI.entity.TabelaCampos;

@Component
public class TabelaCamposRepository {

	
private final SqlSession sqlSession;

public TabelaCamposRepository(SqlSession sqlSession) {
	this.sqlSession = sqlSession;
}


public List<TabelaCampos>buscartabelacampos(){
	List<TabelaCampos>lstabelacampos= new ArrayList<>();
	try {
		TabelaCamposMapper tabelaCamposMapper = this.sqlSession.getMapper(TabelaCamposMapper.class);
		lstabelacampos=tabelaCamposMapper.buscartabeladecampos();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return lstabelacampos;
}



public List<TabelaCampos>buscartabelabynameandcliente(String nameTabela, int idCliente){
	List<TabelaCampos>lstabelacampos= new ArrayList<>();
	try {
		TabelaCamposMapper tabelaCamposMapper = this.sqlSession.getMapper(TabelaCamposMapper.class);
		lstabelacampos=tabelaCamposMapper.buscartabelabynameandcliente(nameTabela,idCliente);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return lstabelacampos;
}


	
	public TabelaCampos buscartabelacampobyClienteId(int id){
		TabelaCampos cliente = new TabelaCampos();
		
		try{
			TabelaCamposMapper clienteMapper = this.sqlSession.getMapper(TabelaCamposMapper.class);
			 
			 cliente=clienteMapper.findbyidcliente(id);
			  }
			  catch(Exception e){
				 e.printStackTrace(); 
				  
			  }

	try{
		TabelaCamposMapper clienteMapper = this.sqlSession.getMapper(TabelaCamposMapper.class);

		 
		 cliente=clienteMapper.findbyidcliente(id);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return cliente;
}
public TabelaCampos inserirtabelacampos(TabelaCampos tabelacampos) {
	int idcliente=0;
	try{
		TabelaCamposMapper tabelaCamposMapper = this.sqlSession.getMapper(TabelaCamposMapper.class);
		 
		 idcliente=tabelaCamposMapper.inserirtabelacampos(tabelacampos);
		 
		 tabelacampos=isTabelaCamposExist(idcliente);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return tabelacampos;
	
}

public TabelaCampos isTabelaCamposExist(int id) {
	TabelaCampos tabelacampos = new TabelaCampos();
	try{
		TabelaCamposMapper tabelaCamposMapper = this.sqlSession.getMapper(TabelaCamposMapper.class);

	
	
		 tabelacampos=tabelaCamposMapper.findbyidcliente(id);
		  }
		  catch(Exception e){
			 e.printStackTrace(); 
			  
		  }
	 
	 return tabelacampos;
}



}
