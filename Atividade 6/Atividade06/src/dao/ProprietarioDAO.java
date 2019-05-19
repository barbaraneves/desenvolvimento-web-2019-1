package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Proprietario;

public class ProprietarioDAO {

	// Create
	public void adicionar(Proprietario proprietario) {
		
		// Iniciando as conexões
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(proprietario);
		
		manager.getTransaction().commit();
		
		// Fechando as conexões
		fabrica.close();
		manager.close();
	}
	
	// Retrieve
	public List<Proprietario> listar() {
		
		// Iniciando as conexões
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Proprietario> proprietarios = manager.createQuery("SELECT p FROM Proprietario AS p").getResultList();
		
		// Fechando as conexões
		fabrica.close();
		manager.close();

		return proprietarios;
	}
	
	// Update
	public void atualizar(Proprietario proprietario) {
		
		// Iniciando as conexões
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.merge(proprietario);
		
		manager.getTransaction().commit();
		
		// Fechando as conexões
		fabrica.close();
		manager.close();
				
		
	}
	
	// Delete
	public void remover(Long codigo) {
		
		// Iniciando as conexões
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, codigo);
		
		manager.getTransaction().begin();
		
		manager.remove(proprietario);
		
		manager.getTransaction().commit();
		
		// Fechando as conexões
		fabrica.close();
		manager.close();
	}
	
	//Buscar
	public Proprietario buscar(Long codigo) {
		
		// Iniciando as conexões
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, codigo);
		
		// Fechando as conexões
		fabrica.close();
		manager.close();
		
		return proprietario;
	}
}
