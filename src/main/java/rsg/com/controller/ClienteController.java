package rsg.com.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	

	
	 @PostMapping("/create")
	    public String createCliente( @RequestParam("clientenombre")String clientenombre, Cliente cliente, Errors errores, Model model ){
		 if(errores.hasErrors()){
	            return "cliente";
	        }
		 
		 cliente.setClienteactivo(true);
		 clienteService.guardar(cliente);
	    	return "redirect:/cliente/";
	    }
	




	
	

}
