# Architecture

This project is a small industrial/edge telemetry system.

The idea is to simulate technical devices that send telemetry data to a backend. The backend validates the incoming data, stores it in PostgreSQL and exposes simple endpoints to inspect the latest readings and the system state.

## Main components

**Device Simulator**

A small C++ simulator that generates telemetry events similar to what an industrial or edge device could send, for example temperature, voltage, battery level, machine state or error codes. The first version is intentionally simple: it generates JSON data locally. Later, the generated events can be sent to the backend through a small shell script or directly through HTTP/MQTT.

**Backend**

A Spring Boot service that receives telemetry events, validates them and stores them in PostgreSQL. It also exposes simple API endpoints for reading the latest data and checking the system state.

**PostgreSQL**

The database stores devices and telemetry events. The first version keeps the schema small and focuses on making ingestion and retrieval work reliably.

**Local Infrastructure**

The project should run locally with Docker Compose. The goal is that another person can clone the repository and start the system with a few commands.

## First target architecture

Device Simulator -> Backend -> PostgreSQL -> API / logs / health checks

## Later additions

MQTT ingestion will be added after the HTTP version works.

CI checks will be added once the backend has a minimal build and test setup.

Basic authentication will be added after the main flow is stable.

At least one failure scenario will be documented, starting with PostgreSQL being unavailable.

## Engineering focus

The system is intentionally small. The main focus is making the project understandable, reproducible and easy to debug.

Important questions for this project:

- Can the system be started locally without hidden steps?
- Is it clear where data enters the system?
- Is invalid data handled explicitly?
- Are logs useful when something fails?
- Can the system report whether it is healthy?
- Are limitations documented honestly?