package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repository.DetailFactureRepository;
import tn.esprit.entity.DetailFacture;

@Service
public class DetailFactureServiceImpl implements IDetailFactureService{
	
	@Autowired
	DetailFactureRepository detailFactureRepository;

	@Override
	public List<DetailFacture> retrieveAllDetails() {
		return (List<DetailFacture>) detailFactureRepository.findAll();
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture df) {
		return detailFactureRepository.save(df);
	}

	@Override
	public void deleteDetailFacture(Long id) {
		detailFactureRepository.deleteById(id);
		
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture df) {
		return detailFactureRepository.save(df);
	}

	@Override
	public DetailFacture retrieveDetailFacture(Long id) {
		return detailFactureRepository.findById(id).orElse(null);
	}

}
