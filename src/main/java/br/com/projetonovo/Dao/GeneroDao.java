package br.com.projetonovo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetonovo.entity.Genero;
import br.com.projetonovo.persistencia.ConexaoFactory;

public class GeneroDao {
Connection con = ConexaoFactory.getConnection();
	
	
	public void cadastrarGenero(Genero gen){
		String sql = "insert into genero (descricao) values (?)";
		try (	PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, gen.getDescricao());
			
			preparador.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void alterar(Genero gen){
		String sql = "update genero set descricao = ? where id = ?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, gen.getDescricao());
			preparador.setInt(2, gen.getId());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Genero> buscaTodosGeneros(){
		List<Genero> listagen = new ArrayList<Genero>();
		String sql = "select * from genero";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			ResultSet rs = preparador.executeQuery();
			while(rs.next()){
			Genero gen = new Genero();
			gen.setId(rs.getInt("id"));
			gen.setDescricao(rs.getString("descricao"));
			
			listagen.add(gen);
				
			}
			return listagen;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void salvarGenero(Genero gen){
		if(gen.getId()!= null && gen.getId()!=0){
			alterar(gen);
		}else{
			cadastrarGenero(gen);
		}
	}
	
}
