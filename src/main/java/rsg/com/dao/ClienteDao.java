package rsg.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rsg.com.domain.Cliente;

public interface ClienteDao extends JpaRepository <Cliente, Long>{
	
@Query(value="SELECT * FROM (\r\n"
		+ "SELECT * FROM cliente \r\n"
		+ "ORDER BY clienteid DESC LIMIT 5) sub \r\n"
		+ "ORDER BY clienteid DESC;",
		nativeQuery=true)
List<Cliente>listOrder();
}
