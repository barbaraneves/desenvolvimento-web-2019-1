package index;

import java.util.ArrayList;

public class UsuarioDAO {
	
	ArrayList<Usuario> pessoas = new ArrayList<Usuario>();
	
	public void cadastrarPessoas() {
		Usuario barbara = new Usuario("barbaraneves", "abc123");
		Usuario julio = new Usuario("juliomartins", "def456");
		
		pessoas.add(barbara);
		pessoas.add(julio);
	}
	
	public Usuario buscarPessoa(String nome, String senha) {
		for (Usuario pessoa : pessoas) {
			if (pessoa.getNome().equals(nome) && pessoa.getSenha().equals(senha)) {
				return pessoa;
			}
		}
		return null;
	}

	public ArrayList<Usuario> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Usuario> pessoas) {
		this.pessoas = pessoas;
	}
}
