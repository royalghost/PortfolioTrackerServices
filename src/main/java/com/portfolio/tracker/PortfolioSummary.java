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
	private Long totalAssets;
	private Long totalLiabilities;
	
	public PortfolioSummary(Long id, Long totalAssets, Long totalLiabilities) {
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
	
	public Long getTotalAssets() {
		return totalAssets;
	}

	public Long getTotalLiabilities() {
		return totalLiabilities;
	}

	public Long getNetWorth() {
		return this.totalAssets - this.totalLiabilities;
	}

}
