/**
 * 
 */
package com.portfolio.tracker;

/**
 * Represents the <code>Portfolio</code> Response.
 * 
 * @author prabinpaudel
 *
 */
public class PortfolioSummary {
	
	private Long id;
	private Double totalAssets;
	private Double totalLiabilities;
	
	public PortfolioSummary(Long id, Double totalAssets, Double totalLiabilities) {
		this.id = id;
		this.totalAssets = totalAssets;
		this.totalLiabilities = totalLiabilities;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getTotalAssets() {
		return totalAssets;
	}

	public Double getTotalLiabilities() {
		return totalLiabilities;
	}

	public Double getNetWorth() {
		return this.totalAssets - this.totalLiabilities;
	}

}
