package com.portfolio.tracker;

public enum AccountType {
	CASH_INVEST(1), 
	LONG_TERM_ASSET(2), 
	SHORT_TERM_LIAB(3), 
	LONG_TERM_LIAB(4);
	
	private final int type;
	
	AccountType(int type) {
		this.type = type;
	}
}
