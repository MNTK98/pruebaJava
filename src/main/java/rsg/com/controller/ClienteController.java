package rsg.com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		Date clientefechamodificacion = null;
		Date clientefechacreacion = null;
		String clientenombre = null;
		Long clienteid = null;
		Boolean clienteactivo = null;
		List <Cliente> cliente = clienteService.listOrder(clienteid, clientenombre,  clienteactivo, 
				 clientefechacreacion,  clientefechamodificacion);
		model.addAttribute("cliente",cliente);
		return "cliente/show";
	}
	
	@PostMapping ("/create")
	public String create( Cliente cliente, Errors errores) {
		if(errores.hasErrors()) {
			return "cliente/show"+"?error";
		}
		clienteService.guardar(cliente);
		return "redirect:/show"+"?success";
	}
	
	

}
