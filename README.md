# Industrial Telemetry Platform
Author: Emmanuele Nukaj

A small backend/infrastructure project for working with simulated telemetry data from industrial or edge devices.

The idea is to simulate devices that send technical data (such as temperature, voltage, battery level, machine state or error codes) to a backend. The backend receives the data, validates it, stores it in PostgreSQL and exposes simple endpoints to inspect the latest readings.

I'm building this project to get more practical with Linux, Docker, PostgreSQL, logging, health checks and basic failure handling in a context that is closer to real technical systems than a normal CRUD app.

The goal is to keep the system small, but make it understandable, reproducible and easy to debug.