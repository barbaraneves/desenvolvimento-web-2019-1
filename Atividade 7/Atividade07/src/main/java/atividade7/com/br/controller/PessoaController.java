package atividade7.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import atividade7.com.br.model.Pessoa;
import atividade7.com.br.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping("/formulario")
	public ModelAndView form() {

		ModelAndView mv = new ModelAndView("Formulario");
		
		mv.addObject("pessoa", new Pessoa());
		
		return mv;
	}
	
	@RequestMapping("/salvar")
	public String salvarPessoa(Pessoa pessoa) {
		
		//Cadastrando um pessoa no banco
		pessoaService.cadastrar(pessoa);
		
		return "Sucesso";
	}
	
	@RequestMapping("/lista-de-pessoas")
	public ModelAndView ListarPessoas() {
		
		//Listar as pessoas que estão presente no banco para a página
		List<Pessoa> pessoas = pessoaService.retornarTodasAsPessoas();
		
		//Conseguimos adicionar objetos para uma certa página com o model and view abaixo
		ModelAndView mv = new ModelAndView("PaginaListagem");
		mv.addObject("listaDePessoas", pessoas);
		
		return mv;
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo) {
		
		pessoaService.excluir(codigo);
		
		ModelAndView mv = new ModelAndView("redirect:/pessoa/lista-de-pessoas");
		
		return mv;
	}
	
	@RequestMapping("/atualizar/{codigo}")
	public ModelAndView atualizar(@PathVariable Long codigo) {
		
		Pessoa pessoa = pessoaService.buscarPorId(codigo);
				
		ModelAndView mv = new ModelAndView("Formulario");
		mv.addObject("pessoa", pessoa);
		
		return mv;
	}

}
