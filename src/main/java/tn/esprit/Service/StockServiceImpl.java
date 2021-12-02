package tn.esprit.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entity.Stock;
import tn.esprit.Repository.StockRepository;

@Service
@Slf4j
public class StockServiceImpl implements IStockService{

	@Autowired
	StockRepository stockRepository;
	
	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		return stocks;
	}

	@Scheduled(cron="59 * * * * *")
	void ruptureStock() {
		Date d = new Date();
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		for(Stock st : stocks)
		{
			if(st.getQteMin()>st.getQteStock())
				System.out.println("Rupture Stock " + st.getIdStock() +" | " +d.toString());
		}
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		return stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		return stockRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);
	}
	

}
