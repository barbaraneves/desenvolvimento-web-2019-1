package atividade7.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import atividade7.com.br.model.Pessoa;
import atividade7.com.br.repository.PessoaRepository;
import atividade7.com.br.util.PessoaFileUtils;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void cadastrar(Pessoa pessoa, MultipartFile imagem) {
		
		//Encriptografando a senha da pessoa
		pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));
		
		//Salvando uma imagem
		String caminho = "imagens/" + pessoa.getNome() + ".png";
		PessoaFileUtils.salvarImagem(caminho, imagem);
		
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
