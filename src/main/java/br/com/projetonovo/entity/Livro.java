package br.com.projetonovo.entity;

public class Livro {
	
		private Integer isbn;
		private String titulo;
		private String descricao;
		private String anoLanc;
		private Integer id_autor;
		private Integer id_genero;
		private String nome_autor;
		private String descricao_genero;
		public Integer getIsbn() {
			return isbn;
		}
		public void setIsbn(Integer isbn) {
			this.isbn = isbn;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getAnoLanc() {
			return anoLanc;
		}
		public void setAnoLanc(String anoLanc) {
			this.anoLanc = anoLanc;
		}
		public Integer getId_autor() {
			return id_autor;
		}
		public void setId_autor(Integer id_autor) {
			this.id_autor = id_autor;
		}
		public Integer getId_genero() {
			return id_genero;
		}
		public void setId_genero(Integer id_genero) {
			this.id_genero = id_genero;
		}
		public String getNome_autor() {
			return nome_autor;
		}
		public void setNome_autor(String nome_autor) {
			this.nome_autor = nome_autor;
		}
		public String getDescricao_genero() {
			return descricao_genero;
		}
		public void setDescricao_genero(String descricao_genero) {
			this.descricao_genero = descricao_genero;
		}
		@Override
		public String toString() {
			return "Livro [isbn=" + isbn + ", titulo=" + titulo + ", descricao=" + descricao + ", anoLanc=" + anoLanc
					+ ", id_autor=" + id_autor + ", id_genero=" + id_genero + ", nome_autor=" + nome_autor
					+ ", descricao_genero=" + descricao_genero + "]";
		}
		
		
		
		
}
