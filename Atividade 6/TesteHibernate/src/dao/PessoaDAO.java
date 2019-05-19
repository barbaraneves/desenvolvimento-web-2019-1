package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;

public class PessoaDAO {

	/* CRUD: 
	 * Create = Criar/Adicionar
	 * Retrieve = Consultar/Listar
	 * Update = Atualizar
	 * Delete = Destruir/Remover
	 */
	
	// Create
	public void adicionar(Pessoa pessoa) {
		
		// Iniciando a conexão
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		// Utilizando o conceito de transação: iniciando a transação 
		manager.getTransaction().begin();
		
		// Cadastrando a pessoa
		manager.persist(pessoa);
		
		// Fechando a transação: confirmando o cadastro
		manager.getTransaction().commit();
		
		// Fechando as conexões
		fabrica.close();
		manager.close();
	}
	
	// Delete
	public void remover(Long id) {
		
		// Iniciando a conexão
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Pessoa pessoa = manager.find(Pessoa.class, id);
		
		// Iniciando uma transação 
		manager.getTransaction().begin();
		
		// Removendo a pessoa
		manager.remove(pessoa);
		
		// Fechando a transação
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	}
	
	// Update
	public void atualizar(Pessoa pessoa) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
				
		manager.getTransaction().begin();
		
		manager.merge(pessoa);
		
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	}
	
	//Retrieve
	public List<Pessoa> listar() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Pessoa> pessoas = manager.createQuery("SELECT p FROM Pessoa AS p").getResultList();
		
		manager.close();
		fabrica.close();
		
		return pessoas;		
	}
	
//	public Pessoa buscar(Long id) {
//		return null;
//		
//	}
}
