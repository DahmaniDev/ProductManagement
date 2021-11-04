package tn.esprit.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Service.IStockService;
import tn.esprit.entity.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

	@Autowired
	IStockService stockService;

	@Test
	public void testAddStock() {
		List<Stock> stocks = stockService.retrieveAllStocks();
		int expected = stocks.size();
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQteStock(10);
		s.setQteMin(100);
		Stock savedStock = stockService.addStock(s);
		assertNotEquals(expected + 1, stocks.size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
	}
	
	@Test
	public void testDeleteStock(){
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQteStock(10);
		s.setQteMin(100);
		Stock savedStock = stockService.addStock(s);
		Long idToBeDeleted = savedStock.getIdStock();
		stockService.deleteStock(idToBeDeleted);
		assertNull(stockService.retrieveStock(idToBeDeleted));
	}
	
	
}
