package rsg.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rsg.com.dao.ClienteDao;
import rsg.com.domain.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public List<Cliente> listarClientes() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	public void guardar(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	public void eliminar(Cliente cliente) {
		clienteDao.delete(cliente);
	}

	@Override
	public Cliente encontrarClientes(Cliente cliente) {
		return clienteDao.findById(cliente.getClienteid()).orElse(null);
	}

}
