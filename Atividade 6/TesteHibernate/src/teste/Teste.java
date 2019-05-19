package teste;

import dao.PessoaDAO;
import model.Pessoa;

public class Teste {
	public static void main(String[] args) {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
			
		/* Adicionando uma pessoa no banco */
		Pessoa barbara = new Pessoa();
		
		barbara.setNome("Barbara");
		barbara.setSerieTV("Game of Thrones"); // :(((((((((((
		
		pessoaDAO.adicionar(barbara);
		
		/* Removendo uma pessoa do banco */
		//pessoaDAO.remover(7L);
	}
}
