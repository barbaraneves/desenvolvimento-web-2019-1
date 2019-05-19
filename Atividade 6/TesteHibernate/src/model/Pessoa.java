package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Entidade Pessoa
@Entity 
public class Pessoa {
	
	// Chave primária
	@Id
	// Para incrementar os valores do id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String serieTV;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSerieTV() {
		return serieTV;
	}
	public void setSerieTV(String serieTV) {
		this.serieTV = serieTV;
	}
	
	

}
