package tn.esprit.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Client;
import tn.esprit.Entity.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>{
	
	@Query("SELECT f FROM Facture f WHERE f.client = :clientParam")
	List<Facture> getFacturesByClient(@Param("clientParam")Client clientParam);
	List<Facture> findByDateFactureBetween(Date dFrom, Date dTo);
}
