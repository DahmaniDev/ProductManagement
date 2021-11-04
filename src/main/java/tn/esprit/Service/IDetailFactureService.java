package tn.esprit.Service;

import java.util.List;

import tn.esprit.entity.DetailFacture;
import org.springframework.stereotype.Service;


@Service
public interface IDetailFactureService {

	List<DetailFacture> retrieveAllDetails();
	
	DetailFacture addDetailFacture(DetailFacture df);
	
	void deleteDetailFacture(Long id);
	
	DetailFacture updateDetailFacture(DetailFacture df);
	
	DetailFacture retrieveDetailFacture(Long id);
}
