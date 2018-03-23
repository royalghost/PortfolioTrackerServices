# PortfolioTrackerServices

HTTP REST API Implementation for POST amd GET using Java, Spring Boot, Redis, Mockito etc.
 
## Request Payload
"{\"assets\":[{\"id\":1,\"name\":\"Chequing\",\"amount\":2004,\"currency\":\"USD\",\"accountType\":null},{\"id\":2,\"name\":\"Savings for Taxes\",\"amount\":4000,\"currency\":\"USD\",\"accountType\":null},{\"id\":3,\"name\":\"Rainy Day Fund\",\"amount\":506,\"currency\":\"USD\",\"accountType\":null},{\"id\":4,\"name\":\"Savings for Fun\",\"amount\":4998,\"currency\":\"USD\",\"accountType\":null},{\"id\":5,\"name\":\"Savings for Travel\",\"amount\":400,\"currency\":\"USD\",\"accountType\":null},{\"id\":6,\"name\":\"Savings for Personal Development\",\"amount\":200,\"currency\":\"USD\",\"accountType\":null},{\"id\":7,\"name\":\"Investment 1\",\"amount\":5000,\"currency\":\"USD\",\"accountType\":null},{\"id\":8,\"name\":\"Investment 2\",\"amount\":60000,\"currency\":\"USD\",\"accountType\":null},{\"id\":9,\"name\":\"Investment 3\",\"amount\":30000,\"currency\":\"USD\",\"accountType\":null},{\"id\":10,\"name\":\"Investment 4\",\"amount\":50000,\"currency\":\"USD\",\"accountType\":null},{\"id\":11,\"name\":\"Investment 5\",\"amount\":24000,\"currency\":\"USD\",\"accountType\":null},{\"id\":12,\"name\":\"Primary Home\",\"amount\":455000,\"currency\":\"USD\",\"accountType\":null},{\"id\":13,\"name\":\"Second Home\",\"amount\":1564321,\"currency\":\"USD\",\"accountType\":null}],\"liabilities\":[{\"id\":14,\"name\":\"Credit Card 1\",\"amount\":4342,\"currency\":\"CAD\",\"accountType\":null},{\"id\":15,\"name\":\"Credit Card 2\",\"amount\":322,\"currency\":\"CAD\",\"accountType\":null},{\"id\":16,\"name\":\"Mortgage 1\",\"amount\":250999,\"currency\":\"CAD\",\"accountType\":null},{\"id\":17,\"name\":\"Mortgage 2\",\"amount\":632634,\"currency\":\"CAD\",\"accountType\":null},{\"id\":18,\"name\":\"Line of Credit\",\"amount\":10000,\"currency\":\"CAD\",\"accountType\":null},{\"id\":19,\"name\":\"Investment Loan\",\"amount\":10000,\"currency\":\"CAD\",\"accountType\":null}]}"

## Response Payload
"{\"id\":7,\"totalAssets\":2200429,\"totalLiabilities\":908297,\"netWorth\":1292132}"


# HTTP Get All 
http://localhost:8080/portfolios/
## Response Payload
[
    "{\"id\":1,\"totalAssets\":2200427,\"totalLiabilities\":908297,\"netWorth\":1292130}",
    "{\"id\":2,\"totalAssets\":2200427,\"totalLiabilities\":908297,\"netWorth\":1292130}",
    "{\"id\":3,\"totalAssets\":2200428,\"totalLiabilities\":908297,\"netWorth\":1292131}",
    "{\"id\":5,\"totalAssets\":2200431,\"totalLiabilities\":908297,\"netWorth\":1292134}",
    "{\"id\":7,\"totalAssets\":2200429,\"totalLiabilities\":908297,\"netWorth\":1292132}",
    "{\"id\":4,\"totalAssets\":2200430,\"totalLiabilities\":908297,\"netWorth\":1292133}",
    "{\"id\":6,\"totalAssets\":2200430,\"totalLiabilities\":908297,\"netWorth\":1292133}"
]


# HTTP Get Details
http://localhost:8080/portfolios/7

#Response Payload
Both POST Request and Response

# Business Use Case
This is a simple demonstration of calculating net worth based on assets and liabilities. 
The first request will be a list of assets and libilities based on which net worth is calculated and response is provided.
Each response will have an unique ID and both request and respose are stored in a persistent system.

# Software Design and Architecutre
This simple servcies implemented demonstrated a service side of HTTP REST API implementation. 

##Here are the high level details:
1. Spring Boot is used to create HTTP End Point through the Controller implementation
2. Service and Database are separate components injected to the Controller through @Autowired Dependency Injection
3. Redis is currently used as a persistent storage to store
4. Redis has two HashMap to store Request and Response as JSON string based on the ID created for each request
5. JUnit and Mockito is use for Unit Testing


##Client Side
Client side app is developed using Angular JS 2. [Will be available soon]

