# URL Shortener

A Spring Boot-based URL Shortener that converts long URLs into short, easy-to-share links. This project uses MySQL for persistent storage and Redis for caching to optimize performance.

## Features
- Shorten long URLs quickly
- Uses **Base62 encoding** to generate unique short URLs
- Retrieve original URL from a shortened URL
- Caching for fast lookups (Redis)
- Database storage (MySQL)
- RESTful APIs for easy integration

## How URL Shortening Works
Our URL Shortener uses **Base62 encoding** to generate short, unique keys for each long URL.

### 🔹 What is Base62 Encoding?
Base62 encoding uses **62 characters (0-9, a-z, A-Z)** to represent numbers in a shorter form.  
Example:  
- **Input:** `100000`  
- **Base62 Encoded Output:** `q0T`  

### 🔹 Why Base62?
- **Shorter URLs** compared to Base10 or Base16 (hex).
- **Alphanumeric format** makes it easy to use in URLs.
- **No special characters**, ensuring browser compatibility.


## Installation & Setup

	### Prerequisites
	- Java 17+
	- Maven
	- Docker (for MySQL and Redis setup)

### Steps to Run the Project

	1. **Clone the repository:**
  		```sh
   		git clone git@github.com:snikitha18/Url-Shortener.git
   		cd url-shortener
   		```

	2. **Set up the MySQL database. Ensure MySQL is installed and running.**

	3. **Set up Redis using Docker:**
   		```sh
    	docker run --name redis -p 6379:6379 -d redis
    	```

	4. **Build and run the application:**
   		```sh
   		mvn clean install
   		mvn spring-boot:run
   		```

	5. **Access Swagger API Documentation:**
 		```
  		http://localhost:8080/swagger-ui.html
    	```

## API Endpoints

	### 1. Shorten a URL
	- **Endpoint:** `POST /UrlShortner/short`
	- **Request Body:**  
		json:    { "ogUrl": "https://example.com" }
	- **Response:**  
		text:	 "http://UrlShortner/shrt.ly/abcd1234" 

	### 2. Retrieve Original URL
	- **Endpoint:** `GET /{shortUrl}`
	- **Response:**  
    	HTML Page:	Redirects to original link

## Technologies Used
	- Java (Spring Boot)
	- MySQL
	- Redis (Caching)
	- Docker (Redis setup)
	- Swagger (API Documentation)

## Contributors
- [Nikitha Somanath](https://github.com/snikitha18)





