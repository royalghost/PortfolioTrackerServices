/**
 * 
 */
package com.portfolio.tracker;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

/**
 * @author prabinpaudel
 *
 */
public class Portfolio {
	
	private List<Account> assets = new ArrayList<Account>();
	private List<Account> liabilities = new ArrayList<Account>();

	public Portfolio() {}
	
	public Portfolio(List<Account> assets, List<Account> liabilities) {
		this.assets = assets;
		this.liabilities = liabilities;
	}

	public List<Account> getAssets() {
		return assets;
	}

	public void setAssets(List<Account> assets) {
		this.assets = assets;
	}

	public List<Account> getLiabilities() {
		return liabilities;
	}

	public void setLiabilities(List<Account> liabilities) {
		this.liabilities = liabilities;
	}
	
	@Override
	public String toString() {
		return new String("Assets : " + Arrays.asList(this.assets) +" and liabilities : " + Arrays.asList(this.liabilities) );
	}

}
