package rsg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import rsg.com.domain.Cliente;
import rsg.com.domain.Consignatario;
import rsg.com.services.ClienteService;
import rsg.com.services.ConsignatarioService;

@Controller
@RequestMapping("/consignatario")
@Slf4j
public class ConsignatarioController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ConsignatarioService consignatarioService;
	
	@GetMapping("/")
	public String inicio (Model model) {
		List <Consignatario> consignatario = consignatarioService.listarConsignatario();
		model.addAttribute("Consignatario",consignatario);
		return "consignatario/show";
	}
}
