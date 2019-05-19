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
		
		// Adicionando o proprietário 2
		Proprietario dany = new Proprietario();
		dany.setNome("Daenerys Targaryen");
		dany.setTelefone("(12) 3.4567-8901");
		dany.setEmail("dany@queen.of.the.ashes.com");
		
		proprietarioDAO.adicionar(dany);
		
		// Adicionando o proprietário 3
		Proprietario jon = new Proprietario();
		jon.setNome("Jon Snow");
		jon.setTelefone("(23) 4.5678-9123");
		jon.setEmail("jon@knows.nothing.com");
		
		proprietarioDAO.adicionar(jon);
		
		// Adicionando o proprietário 4
		Proprietario tyrion = new Proprietario();
		tyrion.setNome("Tyrion Lannister");
		tyrion.setTelefone("(45) 6.7891-2345");
		tyrion.setEmail("tyrion@shocked.face.com");
		
		proprietarioDAO.adicionar(tyrion);
		
		// Adicionando o proprietário 5
		Proprietario arya = new Proprietario();
		arya.setNome("Arya Stark");
		arya.setTelefone("(67) 8.9123-4567");
		arya.setEmail("arya@not.today.com");
		
		proprietarioDAO.adicionar(arya);
		
//		proprietarioDAO.remover(2L);
//		proprietarioDAO.remover(4L);
		
	}
}
