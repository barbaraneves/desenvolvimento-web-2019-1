package atividade7.com.br.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import atividade7.com.br.model.Pessoa;
import atividade7.com.br.repository.PessoaRepository;

@Repository
@Transactional
public class UserDetailsServiceImplementacao implements UserDetailsService {

	@Autowired
	private PessoaRepository pessoaRepository;

	//Encontrando uma pessoa pelo login 
		//No trabalho deve-se colocar o e-mail
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Pessoa pessoa = pessoaRepository.findByLogin(login);
		
		if (pessoa == null) {
			throw new UsernameNotFoundException("Pessoa não encontrada");
		}
		
		return new User(pessoa.getUsername(), pessoa.getPassword(), true, true, true, true, pessoa.getAuthorities());
	}
}
