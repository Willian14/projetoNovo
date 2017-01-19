package br.com.projetonovo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetonovo.entity.Livro;
import br.com.projetonovo.persistencia.ConexaoFactory;

public class LivroDao {
Connection con = ConexaoFactory.getConnection();
	
	public void cadastrarLivro(Livro liv){
		String sql = "insert into livro (isbn,titulo,descricao,anoLanc,id_autor,id_genero,nome_autor,descricao_genero) values(?,?,?,?,?,?,?,?)";
		try (	PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, liv.getIsbn());
			preparador.setString(2, liv.getTitulo());
			preparador.setString(3, liv.getDescricao());
			preparador.setString(4, liv.getAnoLanc());
			preparador.setInt(5, liv.getId_autor());
			preparador.setInt(6, liv.getId_genero());
			preparador.setString(7, liv.getNome_autor());
			preparador.setString(8, liv.getDescricao_genero());
			preparador.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluirLivro(Livro liv){
		String sql = "delete from livro where isbn = ?";
		try (PreparedStatement prep = con.prepareStatement(sql)){
			prep.setInt(1, liv.getIsbn());
			
			prep.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void alterarLivro(Livro liv){
		String sql = "update livro set titulo=?,descricao=?,anoLanc=?,id_autor=?,id_genero=?,nome_autor=?,descricao_genero=? where isbn = ?";
		try (	PreparedStatement prep = con.prepareStatement(sql)){
			
			prep.setString(1, liv.getTitulo());
			prep.setString(2, liv.getDescricao());
			prep.setString(3, liv.getAnoLanc());
			prep.setInt(4, liv.getId_autor());
			prep.setInt(5, liv.getId_genero());
			prep.setString(6, liv.getNome_autor());
			prep.setString(7, liv.getDescricao_genero());
			prep.setInt(8, liv.getIsbn());
			
			
			prep.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Livro> buscarTodosLivros(){
		List<Livro> lista = new ArrayList<Livro>();
		String sql = "select * from livro";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			ResultSet rs = preparador.executeQuery();
			while(rs.next()){
				Livro liv = new Livro();
				liv.setIsbn(rs.getInt("isbn"));
				liv.setTitulo(rs.getString("titulo"));
				liv.setDescricao(rs.getString("descricao"));
				liv.setAnoLanc(rs.getString("anolanc"));
				liv.setId_autor(rs.getInt("id_autor"));
				liv.setId_genero(rs.getInt("id_genero"));
				liv.setNome_autor(rs.getString("nome_autor"));
				liv.setDescricao_genero(rs.getString("descricao_genero"));
				
				lista.add(liv);
			}
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public Livro buscaPorIsbn(int isbn){
		
		String sql = "select * from livro where isbn = ?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setInt(1, isbn);
			
			ResultSet rs =preparador.executeQuery();
			if(rs.next()){
				Livro liv = new Livro();
				liv.setIsbn(rs.getInt("isbn"));
				liv.setTitulo(rs.getString("titulo"));
				liv.setDescricao(rs.getString("descricao"));
				liv.setAnoLanc(rs.getString("anolanc"));
				liv.setId_autor(rs.getInt("id_autor"));
				liv.setId_genero(rs.getInt("id_genero"));
				liv.setNome_autor(rs.getString("nome_autor"));
				liv.setDescricao_genero(rs.getString("descricao_genero"));
				
				return liv;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void salvarLivro(Livro livro){
		Integer isbn = livro.getIsbn();
		
		Livro livroConsulta = buscaPorIsbn(isbn);
		if (livroConsulta != null){
			alterarLivro(livro);
		}else{
			cadastrarLivro(livro);
		}
	}							
}
