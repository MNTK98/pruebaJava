package rsg.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rsg.com.dao.ConsignatarioDao;
import rsg.com.domain.Consignatario;

@Service
public class ConsignatarioServiceImpl implements ConsignatarioService {

	@Autowired
	private ConsignatarioDao consignatarioDao;
	
	@Override
	public List<Consignatario> listarConsignatario() {
		return (List<Consignatario>)consignatarioDao.findAll();
	}

	@Override
	public void guardar(Consignatario consignatario) {
		consignatarioDao.save(consignatario);
	}

	@Override
	public void eliminar(Consignatario consignatario) {
		consignatarioDao.delete(consignatario);
	}

	@Override
	public Consignatario encontrarConsignatario(Consignatario consignatario) {
		return consignatarioDao.findById(consignatario.getConsignatarioid()).orElse(null);
	}

}
