package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Entidade e tabela Proprietário
@Entity
@Table(name = "proprietario")
public class Proprietario {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	// Demais atributos da tabela "proprietario"
	private String nome;
	private String telefone;
	private String email;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
