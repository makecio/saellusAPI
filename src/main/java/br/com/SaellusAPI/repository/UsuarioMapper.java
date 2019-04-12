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
import org.apache.ibatis.annotations.Update;

import br.com.SaellusAPI.entity.Cliente;
import br.com.SaellusAPI.entity.Usuario;

@Mapper
public interface UsuarioMapper {
	
	
	@Select("SELECT * FROM tb_usuario")
	
	 @Results({
	
	  @Result(id=true, property="id", column="id"),
	
	  @Result(property="nome", column="nome"),
	  
	  @Result(property="role", column="role"),
	  
	  @Result(property="perfil", column="perfil"),
	  
	  @Result(property="cpf", column="cpf"),
	  
	  @Result(property="email", column="email"),
	  
	  @Result(property="sobreNome", column="sobreNome"),
	  
	  @Result(property="centroCusto", column="centroCusto"),
	  
	  @Result(property="codCliente", column="codCliente"),
	  
	  @Result(property="ativo", column="ativo"),
	  
	  @Result(property="senha", column="senha"),
	  
	  @Result(property="superiorId", column="superiorId")
	  
		 })
		 public List<Usuario> buscarusuarios();
	
	
	
	
	
	@Select("SELECT * FROM tb_usuario WHERE email=#{email}")
	
	 @Results({
			
		 @Result(id=true, property="id", column="id"),
			
		  @Result(property="nome", column="nome"),
		  
		  @Result(property="role", column="role"),
		  
		  @Result(property="perfil", column="perfil"),
		  
		  @Result(property="cpf", column="cpf"),
		  
		  @Result(property="email", column="email"),
		  
		  @Result(property="sobreNome", column="sobreNome"),
		  
		  @Result(property="centroCusto", column="centroCusto"),
		  
		  @Result(property="codCliente", column="codCliente"),
		  
		  @Result(property="ativo", column="ativo"),
		  
		  @Result(property="senha", column="senha"),
		  
		  @Result(property="superiorId", column="superiorId")
		 })
	public Usuario findusuariobyemail(@Param("email") String email);
	
	
	
	@Select("SELECT * FROM tb_usuario WHERE senha=#{senha}")
	
	 @Results({
			
		 @Result(id=true, property="id", column="id"),
			
		  @Result(property="nome", column="nome"),
		  
		  @Result(property="role", column="role"),
		  
		  @Result(property="perfil", column="perfil"),
		  
		  @Result(property="cpf", column="cpf"),
		  
		  @Result(property="email", column="email"),
		  
		  @Result(property="sobreNome", column="sobreNome"),
		  
		  @Result(property="centroCusto", column="centroCusto"),
		  
		  @Result(property="codCliente", column="codCliente"),
		  
		  @Result(property="ativo", column="ativo"),
		  
		  @Result(property="senha", column="senha"),
		  
		  @Result(property="superiorId", column="superiorId")
		 })
	public Usuario findusuariobysenha(@Param("senha") String senha);
	
	
	
	
	
	@Select("SELECT * FROM tb_usuario WHERE id=#{id}")
	
	 @Results({
			
		 @Result(id=true, property="id", column="id"),
			
		  @Result(property="nome", column="nome"),
		  
		  @Result(property="role", column="role"),
		  
		  @Result(property="perfil", column="perfil"),
		  
		  @Result(property="cpf", column="cpf"),
		  
		  @Result(property="email", column="email"),
		  
		  @Result(property="sobreNome", column="sobreNome"),
		  
		  @Result(property="centroCusto", column="centroCusto"),
		  
		  @Result(property="codCliente", column="codCliente"),
		  
		  @Result(property="ativo", column="ativo"),
		  
		  @Result(property="senha", column="senha"),
		  
		  @Result(property="superiorId", column="superiorId")
		 })
	public Usuario findusuariobyid(@Param("id") int id);
	
	
	@Insert("INSERT INTO tb_usuario (nome,role,perfil,cpf,email,sobreNome,centroCusto,codCliente,ativo,senha,superiorId) "
			+ " VALUES "
			+ " (#{nome},#{role},#{perfil},#{cpf},#{email},#{sobreNome},#{centroCusto},#{codCliente},#{ativo},#{senha},#{superiorId})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@SelectKey(statement="SELECT LAST_INSERT_ID();", keyProperty="id", before=false, resultType=Integer.class)
	
		 public int inserirusuario(Usuario usuario);
	
	@Update("UPDATE tb_usuario SET #{nome},#{role},#{perfil},#{cpf},#{email},#{sobreNome},"
			+ " #{centroCusto},#{codCliente},#{ativo},#{senha},#{superiorId}"
			+ "  WHERE id=#{id}")
	public void atualizausuario(Usuario usuario);
	
	
	@Update("UPDATE tb_usuario SET ativo=#{ativo}"
			+ " WHERE id=#{id}")
	public int deletarusuario(int id);
	


}
