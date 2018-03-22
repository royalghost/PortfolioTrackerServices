package com.portfolio.tracker;

import java.util.List;
import java.util.Map;

public interface PortfolioDatabase {
	
	/**
	 * Save the Portfolio received as a payload from client to the persistent storage
	 * 
	 * @param portfolio
	 * @param portfolioSummary
	 */
	void savePortfolio(Portfolio portfolio, PortfolioSummary portfolioSummary);
	
	/**
	 * Returns the list of all portfolios Summary or response saved to the persistent store so far
	 * @return
	 */
	List<String> getAllPortfoliosSummary();
	
	/**
	 * Returns both the Request and Response payload.
	 * 
	 * @param id
	 * @return
	 */
	Map<String, String> getPortfolioDetails(String id);
}
