package br.com.projetonovo.entity;

public class Genero {
	private Integer id;
	private String descricao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Genero [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
}
