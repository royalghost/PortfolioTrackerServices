/**
 * 
 */
package com.portfolio.tracker;

/**
 * @author prabinpaudel
 *
 */
public interface PortfolioService {
	/**
	 * Calculates networth based on total assets and liabilities
	 * 
	 * @param totalAssets
	 * @param totalLiabilities
	 * @return
	 */
	 PortfolioSummary calculateNetWorth(Portfolio portfolio);
}
