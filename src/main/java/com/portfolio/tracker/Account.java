/**
 * 
 */
package com.portfolio.tracker;

/**
 * @author prabinpaudel
 *
 */
public class Account {
	
	private Long id;
	private String name;
	private Double amount;
	private Currency currency;
	private AccountType accountType;
	
	public Account() {
	}
	
	public Account(Long id, String name, Double amount, Currency currency, AccountType accountType) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.currency = currency;
		this.accountType = accountType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
