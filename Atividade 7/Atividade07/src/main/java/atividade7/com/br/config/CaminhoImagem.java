package atividade7.com.br.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CaminhoImagem implements WebMvcConfigurer {

	//Para dizer ao Spring saber onde que as imagens serão salvas
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imagens/**").addResourceLocations("file:imagens/");
	}	
}
