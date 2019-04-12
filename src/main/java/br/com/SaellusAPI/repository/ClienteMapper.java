package br.com.SaellusAPI.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import br.com.SaellusAPI.entity.Cliente;

import org.apache.ibatis.annotations.Results;

@Mapper
public interface ClienteMapper {
	

	
	@Select("SELECT * FROM tb_cliente")
	
	 @Results({
	
	  @Result(id=true, property="id", column="id"),
	
	  @Result(property="cnpj", column="cnpj"),
	  
	  @Result(property="razaoSocial", column="razaoSocial"),
	  
	  @Result(property="endereco", column="endereco"),
	  
	  @Result(property="numEndereco", column="numEndereco")
	  
		 })
		 public List<Cliente> buscarclientes();
	
	
	@Select("SELECT * FROM tb_cliente WHERE id=#{id}")
	
	 @Results({
			
		  @Result(id=true, property="id", column="id"),
			
		  @Result(property="cnpj", column="cnpj"),
		  
		  @Result(property="razaoSocial", column="razaoSocial"),
		  
		  @Result(property="endereco", column="endereco"),
		  
		  @Result(property="numEndereco", column="numEndereco")
		 })
	public Cliente findclientebyid(@Param("id") int id);
	
	
	@Insert("INSERT INTO tb_cliente (cnpj,razaoSocial,endereco,numEndereco) "
			+ " VALUES "
			+ " (#{cnpj},#{razaoSocial},#{endereco},#{numEndereco})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@SelectKey(statement="SELECT LAST_INSERT_ID();", keyProperty="id", before=false, resultType=Integer.class)
	
		 public int inserircliente(Cliente cliente);
	
	@Update("UPDATE tb_cliente SET cnpj=#{cnpj}, razaoSocial =#{razaoSocial},endereco=#{endereco}, "
			+ " numEndereco =#{numEndereco}"
			+ " WHERE id=#{id}")
	public void atualizacliente(Cliente cliente);
	
	
	@Update("UPDATE tb_cliente SET ativo=#{ativo}"
			+ " WHERE id=#{id}")
	public int deletarcliente(int id);
	


}
