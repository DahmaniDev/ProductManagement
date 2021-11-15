package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Stock;
import tn.esprit.Service.IStockService;

@RestController
@RequestMapping("/Stock")
public class StockController {

	@Autowired
	IStockService stockService;
	
	@PostMapping("/add")
	@ResponseBody
	Stock addStock(@RequestBody Stock f){
		return stockService.addStock(f);
	}
	
	@GetMapping("/get-all")
	@ResponseBody
	List<Stock> getAllStocks(){
		return stockService.retrieveAllStocks();
	}
	
	@GetMapping("/get/{idStock}")
	@ResponseBody
	Stock getStock(@PathVariable("idStock") Long id){
		return stockService.retrieveStock(id);
	}
	@DeleteMapping("/delete/{idStock}")
	@ResponseBody
	void deleteStock(@PathVariable("idStock") Long id){
		stockService.deleteStock(id);
	}
	
	@PutMapping("/update")
	@ResponseBody
	Stock updateStock(@RequestBody Stock f){
		return stockService.updateStock(f);
	}
}
