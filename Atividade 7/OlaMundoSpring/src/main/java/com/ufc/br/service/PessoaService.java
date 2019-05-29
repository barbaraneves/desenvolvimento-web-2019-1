package com.ufc.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void cadastrar(Pessoa pessoa) {
		
		//Cadastrando um pessoa no banco
		pessoaRepository.save(pessoa);
	}
}
