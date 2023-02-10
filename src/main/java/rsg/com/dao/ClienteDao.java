package rsg.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rsg.com.domain.Cliente;

public interface ClienteDao extends JpaRepository <Cliente, Long>{

}
