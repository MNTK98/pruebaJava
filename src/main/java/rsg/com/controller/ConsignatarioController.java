package rsg.com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Long consignatarionombre = null;
		Date consignatarioactivo = null;
		Long consignatarioid = null;
		Boolean consignatariofechacreacion = null;
		String consignatariofechamodificacion = null;
		Date clienteid = null;
		List <Cliente> cliente = clienteService.listarClientes();
		model.addAttribute("cliente",cliente);
		List <Consignatario> consignatario = consignatarioService.listOrder(consignatarioid,
				consignatarionombre, consignatariofechamodificacion, consignatariofechacreacion, consignatarioactivo, clienteid);
		model.addAttribute("consignatario",consignatario);
		return "consignatario/show";
	}
	
	@PostMapping("/create")
    public String createconsignatario(@RequestParam("consignatarionombre")String consignatarionombre, Consignatario consignatario, Errors errores, Model model ){
	 if(errores.hasErrors()){
            return "consignatario";
        }
	 consignatario.setClienteid(consignatario.getConsignatarioid());
	 consignatario.setConsignatarioactivo(true);
	 consignatarioService.guardar(consignatario);
    	return "redirect:/consignatario/";
    }
}
