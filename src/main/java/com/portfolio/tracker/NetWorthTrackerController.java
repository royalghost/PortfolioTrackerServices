/**
 * 
 */
package com.portfolio.tracker;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling HTTP GET and POST Request.
 * 
 * @author prabinpaudel
 *
 */
@CrossOrigin
@RestController(value = "/portfolios")
public class NetWorthTrackerController {
	
	@Autowired
	private PortfolioService portfolioService;
	@Autowired
	private PortfolioDatabase portfolioDatabase;
    private final AtomicLong counter = new AtomicLong();
    
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PortfolioSummary> savePortfolio(@RequestBody Portfolio portfolio ) {
    		//Calculate networth
	    	PortfolioSummary portfolioSummary = portfolioService.calculateNetWorth(portfolio);
	    	portfolioSummary.setId(counter.incrementAndGet());
    		//Save the database
    		portfolioDatabase.savePortfolio(portfolio, portfolioSummary);;
    		
    		return new ResponseEntity<PortfolioSummary>(portfolioSummary, HttpStatus.CREATED);
    }
    
    @GetMapping(produces = "application/json")
    public List<String> getAllPortfoliosSummary(){
    		return portfolioDatabase.getAllPortfoliosSummary();
    }
    
    @GetMapping(produces = "application/json", value="/portfolios/{id}")
    public Map<String, String> getPortfoliosDetails(@PathVariable String id ){
    		return portfolioDatabase.getPortfolioDetails(id);
    }
    
}
