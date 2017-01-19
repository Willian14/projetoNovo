package br.com.projetonovo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetonovo.entity.Autor;
import br.com.projetonovo.persistencia.ConexaoFactory;

public class AutorDao {
private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrarAutor(Autor aut){
		String sql = "insert into autor (nome) values (?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, aut.getNome());
						
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void alterarAutor(Autor aut){
		String sql = "update autor set nome=?  where id =?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, aut.getNome());
			preparador.setInt(2, aut.getId());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Autor>buscaTodos(){
		List<Autor> listaAut = new ArrayList<Autor>();
		String sql="select * from Autor";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			ResultSet rs = preparador.executeQuery();
			while(rs.next()){
				Autor aut = new Autor();
				aut.setId(rs.getInt("id"));
				aut.setNome(rs.getString("nome"));
				listaAut.add(aut);
			}
			return listaAut;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void salvarAutor(Autor aut){
		if(aut.getId() != null && aut.getId() != 0){
			alterarAutor(aut);
		}else{
			cadastrarAutor(aut);
		}
	}
}
