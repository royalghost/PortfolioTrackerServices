package com.portfolio.tracker;

/**
 * Contains both request and response payload.
 * 
 * @author prabinpaudel
 *
 */
public class PortfolioDetail {
	
	private Portfolio portfolio;
	private PortfolioSummary portfolioSummary;

	public PortfolioDetail() {
	}
	
	public PortfolioDetail(Portfolio portfolio, PortfolioSummary portfolioSummary) {
		this.portfolio = portfolio;
		this.portfolioSummary = portfolioSummary;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public PortfolioSummary getPortfolioSummary() {
		return portfolioSummary;
	}

	public void setPortfolioSummary(PortfolioSummary portfolioSummary) {
		this.portfolioSummary = portfolioSummary;
	}

}
