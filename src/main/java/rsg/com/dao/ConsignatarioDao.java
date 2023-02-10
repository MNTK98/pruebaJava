package rsg.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rsg.com.domain.Consignatario;

public interface ConsignatarioDao extends JpaRepository<Consignatario, Long> {
	
	@Query(value="SELECT * FROM (\r\n"
			+ "SELECT * FROM consignatario \r\n"
			+ "ORDER BY consignatarioid DESC LIMIT 5) sub \r\n"
			+ "ORDER BY consignatarioid DESC;",
			nativeQuery=true)
	List<Consignatario>listOrder();
	

}
