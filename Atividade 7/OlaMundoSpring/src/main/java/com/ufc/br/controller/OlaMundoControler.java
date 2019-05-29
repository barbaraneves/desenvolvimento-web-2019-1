package com.ufc.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoControler {

	@RequestMapping("/olamundo")
	public String form() {
		
		return "OlaMundo";
	}
}
