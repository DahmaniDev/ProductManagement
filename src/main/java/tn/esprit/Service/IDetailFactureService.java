package tn.esprit.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Entity.DetailFacture;


public interface IDetailFactureService {

	List<DetailFacture> retrieveAllDetails();
	
	DetailFacture addDetailFacture(DetailFacture df);
	
	void deleteDetailFacture(Long id);
	
	DetailFacture updateDetailFacture(DetailFacture df);
	
	DetailFacture retrieveDetailFacture(Long id);
}
