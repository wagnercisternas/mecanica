package com.wasc.mecanica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wasc.mecanica.model.Cliente;
import com.wasc.mecanica.repository.Clientes;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private Clientes clientes;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject(new Cliente());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public String salvar(@Validated Cliente cliente, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "CadastroCliente";
		}
		
		clientes.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return "redirect:/cliente/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Cliente> todosClientes = clientes.findAll();
		ModelAndView mv = new ModelAndView("PesquisaCliente");
		mv.addObject("clientes",todosClientes);
		
		return mv;
	}
}
