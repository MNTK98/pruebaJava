package rsg.com.services;

import java.util.Date;
import java.util.List;

import rsg.com.domain.Cliente;

public interface ClienteService {
	
	public List<Cliente>listarClientes();
	
	public void guardar(Cliente cliente);
	
	public void eliminar(Cliente cliente);
	
	public Cliente encontrarClientes(Cliente cliente);

	List<Cliente> listOrder(Long clienteid, String clientenombre, Boolean clienteactivo, Date clientefechacreacion,
			Date clientefechamodificacion);
	
	
}
