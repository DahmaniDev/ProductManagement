package tn.esprit.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
	
	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN '1995/01/01' AND '1995/12/31'")
	List<Client> retrieveClientsByBirthDate();
	
}
