# Roadmap

The goal is to build this project in small working steps.

## Milestone 1: Project skeleton

- README
- basic folder structure
- architecture document
- roadmap document
- .gitignore

## Milestone 2: Device simulator

- Python script that generates sample telemetry events
- multiple device IDs
- realistic fields such as timestamp, temperature, voltage, battery level, machine state and error code
- output as JSON
- short simulator README or usage note

## Milestone 3: Backend basics

- Spring Boot backend
- health endpoint
- endpoint for receiving telemetry data
- basic payload validation
- simple error responses

## Milestone 4: Database persistence

- PostgreSQL database
- Docker Compose setup
- telemetry events stored in the database
- endpoint for reading the latest event per device

## Milestone 5: Reproducible local setup

- backend, database and simulator can be run locally
- clear setup commands in README
- no hidden manual steps
- basic scripts for sending sample data and checking health

## Milestone 6: Observability basics

- useful logs
- health checks
- clear error behavior when the database is unavailable
- first documented failure scenario

## Milestone 7: CI and quality

- GitHub Actions workflow
- backend build check
- minimal tests
- validation logic covered by tests

## Milestone 8: MQTT ingestion

- local MQTT broker
- simulator can publish telemetry events via MQTT
- backend can receive and store MQTT messages

## Milestone 9: Security basics

- simple API key or token-based protection
- secrets not hardcoded
- basic threat model
- logs do not expose sensitive data

## Final job-proof version

The final version should demonstrate:

- Linux and command-line comfort
- Docker Compose
- backend development
- PostgreSQL
- HTTP and MQTT ingestion
- logging
- health checks
- CI checks
- basic testing
- basic security awareness
- documented failure behavior
- clear technical documentation

The project is complete enough when I can explain every component, start it locally, send sample data, inspect stored events, show logs, break one component intentionally and explain what happens.