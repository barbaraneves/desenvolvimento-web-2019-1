package dao;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
	
	private List<Usuario> pessoas;
	
	public UsuarioDAO() {
		pessoas = new ArrayList<Usuario>();
		
		//Usários salvos
		Usuario barbara = new Usuario("barbaraneves", "abc123");
		Usuario julio = new Usuario("juliomartins", "def456");
		
		pessoas.add(barbara);
		pessoas.add(julio);
	}
	
	public Usuario buscarUsuario(String nome, String senha) {
		Usuario pessoa = new Usuario(nome, senha);
		
		if (pessoas.contains(pessoa)) {
			return pessoa;
		}
		
		return null;
	}

	public List<Usuario> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Usuario> pessoas) {
		this.pessoas = pessoas;
	}
}
