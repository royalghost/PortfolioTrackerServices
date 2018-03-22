package com.portfolio.tracker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolio.tracker.Account;
import com.portfolio.tracker.AccountType;
import com.portfolio.tracker.Currency;
import com.portfolio.tracker.NetWorthTrackerController;
import com.portfolio.tracker.Portfolio;
import com.portfolio.tracker.PortfolioDatabase;
import com.portfolio.tracker.PortfolioService;
import com.portfolio.tracker.PortfolioSummary;

public class NetWorthTrackerControllerTest {
	
	@InjectMocks
	private NetWorthTrackerController netWorthTrackerControllerMock;
	
	@Mock 
	private PortfolioDatabase portfolioDB;
	
	@Mock
	private PortfolioService portfolioService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNetWorthTracker() {
		//Given
		List<Account> assets = new ArrayList<Account>();
		assets.add(new Account(new Long(1), "Asset1", new Long(1000), Currency.CAD, AccountType.LONG_TERM_ASSET));
		assets.add(new Account(new Long(1), "Asset2", new Long(2000), Currency.CAD, AccountType.CASH_INVEST));
		List<Account> liabilities = new ArrayList<Account>();
		liabilities.add(new Account(new Long(1), "Liability1", new Long(500), Currency.CAD, AccountType.LONG_TERM_LIAB));
		liabilities.add(new Account(new Long(1), "Liability2", new Long(300), Currency.CAD, AccountType.SHORT_TERM_LIAB));
		Portfolio portfolio = new Portfolio(assets, liabilities);
		PortfolioSummary portfolioSummary = Mockito.mock(PortfolioSummary.class);
		//When
		Mockito.when(portfolioService.calculateNetWorth(portfolio)).thenReturn(portfolioSummary);
		ResponseEntity<PortfolioSummary> actual = netWorthTrackerControllerMock.savePortfolio(portfolio);
		//Then
		assertEquals( actual.getStatusCode(), HttpStatus.CREATED);
	}

}
