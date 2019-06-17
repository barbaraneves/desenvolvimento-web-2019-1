package atividade7.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView salvarPessoa(@Validated Pessoa pessoa, BindingResult result, @RequestParam(value="imagem") MultipartFile imagem) {
		
		ModelAndView mv = new ModelAndView("Formulario");
		
		if (result.hasErrors()) {
			return mv;
		}
		
		mv.addObject("mensagem", "Pessoa cadastrada com sucesso!");
		//Cadastrando um pessoa no banco
		pessoaService.cadastrar(pessoa, imagem);
		
		return mv;
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
