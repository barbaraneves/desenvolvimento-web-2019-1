package atividade7.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade7.com.br.model.Pessoa;
import atividade7.com.br.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void cadastrar(Pessoa pessoa) {
		
		//Cadastrando um pessoa no banco
		pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> retornarTodasAsPessoas() {
		
		return pessoaRepository.findAll();
		
	}
	
	public void excluir(Long codigo) {
		
		pessoaRepository.deleteById(codigo);
	}

	public Pessoa buscarPorId(Long codigo) {
		
		return pessoaRepository.getOne(codigo);
	}
}