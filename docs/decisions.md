# Architecture Decision Log

This document tracks the major technical decisions, rationale, and trade-offs made throughout the project lifecycle.

---

### 1. Device Simulator Language (C++ vs Python)
* **Date:** 2026-05-18
* **Context:** The platform requires a local simulator to generate realistic telemetry data before integrating physical edge hardware.
* **Decision:** Develop the core simulator in C++ for data generation (local JSON output) and delegate the network layer to a simple Bash script using `curl`.
* **Rationale:** C++ perfectly aligns with the cyber-physical/embedded domain. Delegating network ingestion to Bash prevents premature complexity (like introducing heavy C++ HTTP libraries such as `libcurl`), keeping the simulator codebase clean, minimal, and modular.

### 2. Backend Tech Stack & Java Version (Java 17 + Spring Boot)
* **Date:** 2026-05-18
* **Context:** The system requires a backend service to handle telemetry data ingestion, payload validation, and system monitoring.
* **Decision:** Use Java 17 (LTS) with Spring Boot (Spring Web and Actuator) managed by Maven.
* **Rationale:** Java 17 is a solid, industry-standard Long-Term Support (LTS) version heavily used in production environments. Spring Boot drastically cuts down boilerplate code by providing an embedded Tomcat server out of the box. Including Spring Boot Actuator gives us production-ready monitoring endpoints (like `/actuator/health`) with zero manual implementation overhead.

### 3. Data Ingestion Architecture (Controller + DTO Pattern)
* **Date:** 2026-05-18
* **Context:** The ingestion endpoint needs to safely parse and validate incoming JSON payloads from the C++ device simulator.
* **Decision:** Implement the REST API using a dedicated `TelemetryController` and decouple the network payload mapping via a `TelemetryEventDto` class.
* **Rationale:** This pattern enforces separation of concerns. Spring Boot handles the automatic conversion from raw JSON text to Java objects. Keeping validation inside the controller ensures that malformed data (such as empty device IDs or out-of-range battery values) is rejected immediately with an HTTP 400 (Bad Request), protecting downstream system components from processing corrupted data.