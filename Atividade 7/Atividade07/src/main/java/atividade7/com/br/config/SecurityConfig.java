package atividade7.com.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import atividade7.com.br.security.UserDetailsServiceImplementacao;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImplementacao userDetaisServiceImple;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
		
		//Lista de todas as URLs que podem ser acessadas
		.antMatchers("/pessoa/formulario").hasRole("USER")
		.antMatchers("/pessoa/salvar").permitAll()
		.antMatchers("/pessoa/lista-de-pessoas").permitAll()
		
		//A partir daqui, as URLs só podem ser acessadas com autenticação
		.anyRequest().authenticated()
		
		//Dizer qual o controller que vai retornar o formulário de login
		.and()
		.formLogin()
		.loginPage("/pessoa/login").defaultSuccessUrl("/pessoa/index").permitAll()
		
		//Dizer qual o controller que vai retornar o formulário de logout
		.and()
		.logout()
		.logoutSuccessUrl("/pessoa/login?logout")
		.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetaisServiceImple).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override	
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**", "/imagens/**");
	}	
}
