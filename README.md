**Logistics Tracking Microservices**

**Overview**

The Logistics Tracking Microservices project delivers a scalable, efficient, and secure RESTful API for generating unique parcel tracking numbers. Designed using a microservices architecture, the system supports high concurrency and horizontal scalability. It leverages Spring Boot, Docker Compose, Spring Cloud (Config Server, Gateway, Eureka Server), MongoDB, and integrates Grafana and Prometheus for monitoring. Security is enforced via Spring Security at the gateway level.

**Features**

Tracking Number Generation API. Exposes a GET /next-tracking-number endpoint to generate tracking numbers.
Accepts detailed query parameters, including origin and destination countries, parcel weight, timestamp, and customer information.
Ensures all tracking numbers conform to the regex pattern ^[A-Z0-9]{1,16}$ and are globally unique.
Optimized for high performance and concurrent access.

**Microservices Architecture**

Tracking Service: Core service that handles tracking number generation logic and data persistence.
Gateway Service: Entry point for all external requests; handles routing, authentication, and authorization.
Eureka Server: Facilitates service discovery for dynamic service registration and discovery.
Config Server: Centralized configuration management across all services.

**Technology Stack**

1: Java 17
2: Spring Boot
3: Spring Cloud (Gateway, Eureka, Config)
4: MongoDB
5: Docker + Docker Compose
6: Grafana + Prometheus
7: Spring Security
8: Scalability and Performance
9: Engineered to handle a high volume of concurrent requests.
10: Built with scalability in mind, supporting horizontal scaling across microservices.
11: Monitoring and Logging
12: Integrated with Prometheus for metrics collection.
13: Uses Grafana for real-time visualization and monitoring dashboards.

**API Specification**

**Endpoint:**
GET api/next-tracking-number

**Query Parameters:**

1: Parameter	Format/Type	Description
2: origin_country_id	ISO 3166-1 alpha-2	Country code of parcel origin
3: destination_country_id	ISO 3166-1 alpha-2	Country code of parcel destination
4: weight	Decimal (up to 3 decimal places)	Parcel weight in kilograms
5: created_at	RFC 3339 timestamp	Timestamp of parcel creation
6: customer_id	UUID	Unique identifier for the customer
7: customer_name	String	Name of the customer
8: customer_slug	kebab-case string	Slugified customer name (e.g., example-corp)

**Response Format:**
json
{
  "tracking_number": "AB123456789XYZ",
  "created_at": "2024-07-26T10:00:00Z"
  // Additional fields as applicable
}

**Project Structure**

logistics-tracking/
├── configserver/           # Spring Cloud Config Server
├── eurekaserver/           # Eureka Service Discovery
├── gatewayserver/          # API Gateway with Spring Security
├── tracking/               # Core service for tracking numbers
│   ├── entity/             # MongoDB entity classes
│   ├── repository/         # Spring Data MongoDB repositories
│   ├── service/            # Business logic
│   ├── controller/         # REST API controllers
│   ├── model/              # DTOs for requests and responses
│   ├── exception/          # Global exception handling
├── docker-compose.yml      # Docker Compose configuration
└── grafana-prometheus/     # Monitoring stack configuration
