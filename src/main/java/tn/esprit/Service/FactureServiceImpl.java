package tn.esprit.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entity.CategorieClient;
import tn.esprit.Entity.Client;
import tn.esprit.Entity.Facture;
import tn.esprit.Repository.ClientRepository;
import tn.esprit.Repository.FactureRepository;

@Slf4j
@Service
public class FactureServiceImpl implements IFactureService{
	
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Facture> retrieveAllFactures() {
		return (List<Facture>) factureRepository.findAll();
	}
	
	@Scheduled(cron="* * * 1 * *")
	void revenueMagasin(){
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		float tot=0;
		for(Facture f:factures)
			tot+=f.getMontantRemise();
		System.out.println(tot);
	}

	@Override
	public void cancelFacture(Long id) {
		Facture f = factureRepository.findById(id).orElse(null);
		f.setActive(false);
		log.info("Facture Canceled : " +f);
		factureRepository.save(f);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return factureRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Facture addFacture(Facture f) {
		clientRepository.save(f.getClient());
		return factureRepository.save(f);
	}

	public List<Facture> getFacturesByClient(Long idClient){
		Client c = clientRepository.findById(idClient).orElse(null);
		if (c!=null)
			return factureRepository.getFacturesByClient(c);
		else
			return null;
	}

	@Override
	public Facture addFacture(Facture f, Long idClient) {
		Client c = clientRepository.findById(idClient).orElse(null);
		if(c!=null)
			f.setClient(c);
		return factureRepository.save(f);
	}

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		List<Facture> factures = factureRepository.findByDateFactureBetween(startDate, endDate);
		float res=0;
		for(Facture f : factures){
			if(f.getClient().getCategorieClient().equals(categorieClient))
				res+=f.getMontantFacture();
		}
		return res;
	}

}
