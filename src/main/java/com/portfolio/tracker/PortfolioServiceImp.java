/**
 * 
 */
package com.portfolio.tracker;

import org.springframework.stereotype.Component;

/**
 * Calculates Networth and other financial data for a given portfolio.
 * 
 * @author prabinpaudel
 *
 */
@Component
public class PortfolioServiceImp implements PortfolioService {

	public PortfolioServiceImp() {
	}

	/* (non-Javadoc)
	 * @see com.intuit.networthtracker.PortfolioService#calculateNetWorth(com.intuit.networthtracker.Portfolio)
	 */
	public PortfolioSummary calculateNetWorth(Portfolio portfolio) {
    	
		Long totalAssets = new Long(0);
		for (Account account : portfolio.getAssets()) {
			if (account.getAmount() != null)
				totalAssets += account.getAmount();
		}
		
		Long totalLiabilities = new Long(0);
		for(Account account : portfolio.getLiabilities()) {
			if (account.getAmount() != null) {
				totalLiabilities += account.getAmount();
			}
		}
		
		return new PortfolioSummary(new Long(0), totalAssets, totalLiabilities);
	}

}
