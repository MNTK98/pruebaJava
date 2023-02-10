package rsg.com.services;


import java.util.List;

import rsg.com.domain.Consignatario;

public interface ConsignatarioService {
	
	public List<Consignatario>listarConsignatario();
	
	public void guardar (Consignatario consignatario);
	
	public void eliminar (Consignatario consignatario);
	
	public Consignatario encontrarConsignatario(Consignatario consignatario);
}
