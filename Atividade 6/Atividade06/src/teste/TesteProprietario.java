package teste;

import dao.ProprietarioDAO;
import model.Proprietario;

public class TesteProprietario {
	
	public static void main(String[] args) {
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		
		// Adicionando o proprietário 1
		Proprietario barbara = new Proprietario();
		barbara.setNome("Bárbara Neves");
		barbara.setTelefone("(85) 9.1234-5678");
		barbara.setEmail("barbara.steph@alu.ufc.br");
		
		proprietarioDAO.adicionar(barbara);
	}

}
