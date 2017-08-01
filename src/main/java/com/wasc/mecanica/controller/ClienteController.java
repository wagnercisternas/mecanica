package com.wasc.mecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wasc.mecanica.model.Cliente;
import com.wasc.mecanica.repository.Clientes;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private Clientes clientes;
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroCliente";
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public ModelAndView salvar(Cliente cliente) {
		
		clientes.save(cliente);
		
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject("mensagem", "Cliente salvo com sucesso!");
		return mv;
	}
}
