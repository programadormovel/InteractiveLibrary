package br.itb.projeto.interactiveLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.itb.projeto.interactiveLibrary.model.repository.UsuarioRepository;

@Service
public class UsuarioService1 {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public boolean usuarioLogin(String usuario, String senha) {
		if(usuario.equals(usuarioRepository.findByEmail(usuario))) {
			if(senha.equals(usuarioRepository.findBySenha(senha))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
