package br.com.SaellusAPI.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import br.com.SaellusAPI.entity.Cliente;
import br.com.SaellusAPI.entity.TabelaCampos;


@Mapper
public interface TabelaCamposMapper {
	
	@Select("SELECT * FROM tb_tabela_campos")
	
	@Results({
		
		 @Result(id=true, property="id", column="id"),
		
		 @Result(property="coluna", column="coluna"),
		 
		 @Result(property="tipoColuna", column="tipoColuna"),
		  
		 @Result(property="tamanhoColuna", column="tamanhoColuna"),
		  
		 @Result(property="nameColuna", column="nameColuna"),
		  
		 @Result(property="perfilAcessoColuna", column="perfilAcessoColuna"),
		 
		 @Result(property="ativo", column="ativo"),
		 
		 @Result(property="perfilAcessoColuna", column="perfilAcessoColuna"),
		 
		 @Result(property="codCliente", column="codCliente"),
		 
		 @Result(property="tabela", column="tabela"),
		 
		 @Result(property="nameTabela", column="nameTabela"),
		 
		 @Result(property="tipoForm", column="tipoForm"),
		 
		 @Result(property="opcoes", column="opcoes")
		  
	  
		 })
		 public List<TabelaCampos> buscartabeladecampos();
	
	@Select("SELECT * FROM tb_tabela_campos WHERE nameTabela=#{nameTabela} AND codCliente=#{idCliente}")
	
	 @Results({
	
	 @Result(id=true, property="id", column="id"),
	
	 @Result(property="coluna", column="coluna"),
	 
	 @Result(property="tipoColuna", column="tipoColuna"),
	  
	 @Result(property="tamanhoColuna", column="tamanhoColuna"),
	  
	 @Result(property="nameColuna", column="nameColuna"),
	  
	 @Result(property="perfilAcessoColuna", column="perfilAcessoColuna"),
	 
	 @Result(property="ativo", column="ativo"),
	 
	 @Result(property="perfilAcessoColuna", column="perfilAcessoColuna"),
	 
	 @Result(property="codCliente", column="codCliente"),
	 
	 @Result(property="tabela", column="tabela"),
	 
	 @Result(property="nameTabela", column="nameTabela"),
	 
	 @Result(property="tipoForm", column="tipoForm"),
	  
	 @Result(property="opcoes", column="opcoes")
	  
		 })
		 public List<TabelaCampos> buscartabelabynameandcliente(@Param("nameTabela") String nameTabela,@Param("idCliente") int idCliente);
	
	
	@Select("SELECT * FROM tb_tabela_campos WHERE codCliente=#{codCliente}")
	
	@Results({
		
		 @Result(id=true, property="id", column="id"),
		
		 @Result(property="coluna", column="coluna"),
		 
		 @Result(property="tipoColuna", column="tipoColuna"),
		  
		 @Result(property="tamanhoColuna", column="tamanhoColuna"),
		  
		 @Result(property="nameColuna", column="nameColuna"),
		  
		 @Result(property="perfilAcessoColuna", column="perfilAcessoColuna"),
		 
		 @Result(property="ativo", column="ativo"),
		 
		 @Result(property="perfilAcessoColuna", column="perfilAcessoColuna"),
		 
		 @Result(property="codCliente", column="codCliente"),
		 
		 @Result(property="tabela", column="tabela"),
		 
		 @Result(property="nameTabela", column="nameTabela"),
		 
		 @Result(property="tipoForm", column="tipoForm"),
		 
		 @Result(property="opcoes", column="opcoes")
		  
		 })
	public TabelaCampos findbyidcliente(@Param("codCliente") int id);
	
	
	@Insert("INSERT INTO tb_tabela_campos (descriColuna,tipoColuna,tamanhoColuna,perfilAcessoColuna,"
			+ "	ativo,tipoForm,codCliente) "
			+ " VALUES "
			+ " (#{descriColuna},#{tipoColuna},#{tamanhoColuna},#{perfilAcessoColuna},#{ativo},#{tipoForm},#{codCliente}")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@SelectKey(statement="SELECT LAST_INSERT_ID();", keyProperty="id", before=false, resultType=Integer.class)
	
		 public int inserirtabelacampos(TabelaCampos tabelacampos);
	

}
