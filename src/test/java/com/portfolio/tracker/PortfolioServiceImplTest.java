/**
 * 
 */
package com.portfolio.tracker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.portfolio.tracker.Account;
import com.portfolio.tracker.AccountType;
import com.portfolio.tracker.Currency;
import com.portfolio.tracker.Portfolio;
import com.portfolio.tracker.PortfolioServiceImp;
import com.portfolio.tracker.PortfolioSummary;

/**
 * @author prabinpaudel
 *
 */
public class PortfolioServiceImplTest {
	
	@InjectMocks
	private PortfolioServiceImp portfolioServiceMock;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test method for {@link com.portfolio.tracker.PortfolioServiceImp#calculateNetWorth(com.portfolio.tracker.Portfolio)}.
	 */
	@Test
	public void testCalculateNetWorth_NotNull() {
		//Given
		Portfolio portfolio = new Portfolio(new ArrayList<Account>(), new ArrayList<Account>());
		//When
		PortfolioSummary actualResult = portfolioServiceMock.calculateNetWorth(portfolio);
		//Then
		assertNotNull(actualResult);
	}
	
	/**
	 * Test method for {@link com.portfolio.tracker.PortfolioServiceImp#calculateNetWorth(com.portfolio.tracker.Portfolio)}.
	 */
	@Test
	public void testCalculateNetWorth_ForZero() {
		//Given
		Portfolio portfolio = new Portfolio(new ArrayList<Account>(), new ArrayList<Account>());
		//When
		PortfolioSummary actualResult = portfolioServiceMock.calculateNetWorth(portfolio);
		//Then
		assertEquals(new Long(0), actualResult.getNetWorth());
	}
	
	/**
	 * Test method for {@link com.portfolio.tracker.PortfolioServiceImp#calculateNetWorth(com.portfolio.tracker.Portfolio)}.
	 */
	@Test
	public void testCalculateNetWorth_WithValue() {
		//Given
		List<Account> assets = new ArrayList<Account>();
		assets.add(new Account(new Long(1), "Asset1", new Double(1000), Currency.CAD, AccountType.LONG_TERM_ASSET));
		assets.add(new Account(new Long(1), "Asset2", new Double(2000), Currency.CAD, AccountType.CASH_INVEST));
		List<Account> liabilities = new ArrayList<Account>();
		liabilities.add(new Account(new Long(1), "Liability1", new Double(500), Currency.CAD, AccountType.LONG_TERM_LIAB));
		liabilities.add(new Account(new Long(1), "Liability2", new Double(300), Currency.CAD, AccountType.SHORT_TERM_LIAB));
		Portfolio portfolio = new Portfolio(assets, liabilities);
		PortfolioSummary expectedPortfolioSummary = new PortfolioSummary(new Long(1), new Double(3000), new Double(800));
		//When
		PortfolioSummary actualResult = portfolioServiceMock.calculateNetWorth(portfolio);
		//Then
		assertEquals(expectedPortfolioSummary.getNetWorth(), actualResult.getNetWorth());
		
	}

}
