package br.itb.projeto.interactiveLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	@GetMapping("/index")
	public String index() {
		return "/index";
	}
	
	@GetMapping("1tela_template")
	public String tela_template() {
		return "/pages/1tela_template";
	}
	
	

	@GetMapping("tela_inicial")
	public String tela_inicial() {
		return "/pages/tela_inicial";
	}
	
	@GetMapping("materias_videos")
	public String materias_videos() {
		return "/pages/materias_videos";
	}
	
	@GetMapping("materias_livros")
	public String materias_livros() {
		return "/pages/materias_livros";
	}
	
	@GetMapping("tela_perfil")
	public String tela_perfil() {
		return "/pages/tela_perfil";
	}
	
	@GetMapping("livro_pag1")
	public String livro_pag1() {
		return "/pages/livro_pag1";
	}
	
	@GetMapping("livro_pag2")
	public String livro_pag2() {
		return "/pages/livro_pag2";
	}
	
	@GetMapping("livro_pag3")
	public String livro_pag3() {
		return "/pages/livro_pag3";
	}
	
	@GetMapping("video_geografia")
	public String video_geografia() {
		return "/pages/video_geografia";
	}
	
	@GetMapping("video_matematica")
	public String video_matematica() {
		return "/pages/video_matematica";
	}
	
	@GetMapping("video_portugues")
	public String video_portugues() {
		return "/pages/video_portugues";
	}
	
	
}
