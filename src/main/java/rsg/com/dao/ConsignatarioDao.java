package rsg.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rsg.com.domain.Consignatario;

public interface ConsignatarioDao extends JpaRepository<Consignatario, Long> {

}
