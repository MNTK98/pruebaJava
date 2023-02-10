package rsg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import rsg.com.domain.Cliente;
import rsg.com.services.ClienteService;

@Controller
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {
		
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public String inicio (Model model) {
		List <Cliente> cliente = clienteService.listarClientes();
		model.addAttribute("cliente",cliente);
		return "cliente/show";
	}
	

}
