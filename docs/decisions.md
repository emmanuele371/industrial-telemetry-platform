# Architecture Decision Log

This document tracks the major technical decisions, rationale, and trade-offs made throughout the project lifecycle.

---

### 1. Device Simulator Language (C++ vs Python)
* **Date:** 2026-05-18
* **Context:** The platform requires a local simulator to generate realistic telemetry data before integrating physical edge hardware.
* **Decision:** Develop the core simulator in C++ for data generation (local JSON output) and delegate the network layer to a simple Bash script using "curl".
* **Rationale:** C++ perfectly aligns with the cyber-physical/embedded domain. Delegating network ingestion to Bash prevents premature complexity (like introducing heavy C++ HTTP libraries such as "libcurl"), keeping the simulator codebase clean, minimal, and modular.