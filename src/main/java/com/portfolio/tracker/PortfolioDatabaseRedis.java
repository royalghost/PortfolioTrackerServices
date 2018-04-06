package com.portfolio.tracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.lettuce.core.*;
import io.lettuce.core.api.StatefulRedisConnection;

@Component
public class PortfolioDatabaseRedis implements PortfolioDatabase {
	
	public static final String PORTFOLIO_REQUEST_MAP = "PORTFOLIO_REQUEST_MAP";
	public static final String PORTOFLIO_RESPONSE_MAP = "PORTOFLIO_RESPONSE_MAP";
	public static final String PORTFOLIO_REQUEST_DETAIL_KEY = "request";
	public static final String PORTFOLIO_RESPONSE_DETAIL_KEY = "response";
	
	public PortfolioDatabaseRedis() {
	}
	
	private StatefulRedisConnection<String, String> getConnection() {
		RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
		return redisClient.connect();
	}

	public void savePortfolio(Portfolio portfolio, PortfolioSummary portfolioSummary) {

		ObjectWriter ow = new ObjectMapper().writer();
		String portfolioData = null, portfolioSummaryData = null;
		try {
			portfolioData = ow.writeValueAsString(portfolio);
			portfolioSummaryData = ow.writeValueAsString(portfolioSummary);
		} catch (JsonProcessingException e) {
			System.err.println(e.getMessage());
		}
		Long id = portfolioSummary.getId();
		StatefulRedisConnection<String, String> connection = getConnection();
		connection.sync().hset(PORTFOLIO_REQUEST_MAP, String.valueOf(id), portfolioData);
		connection.sync().hset(PORTOFLIO_RESPONSE_MAP, String.valueOf(id), portfolioSummaryData);
		connection.close();
	}
	
	public List<String> getAllPortfoliosSummary(){
		StatefulRedisConnection<String, String> connection = getConnection();
		return connection.sync().hvals(PORTOFLIO_RESPONSE_MAP);
	}

	public Map<String, String> getPortfolioDetails(final String id) {
		StatefulRedisConnection<String, String> connection = getConnection();
		Map<String, String> map = new HashMap<String, String>();
		map.put(PORTFOLIO_REQUEST_DETAIL_KEY, connection.sync().hget(PORTFOLIO_REQUEST_MAP, id));
		map.put(PORTFOLIO_RESPONSE_DETAIL_KEY, connection.sync().hget(PORTOFLIO_RESPONSE_MAP, id));
		return map;
	}

}
