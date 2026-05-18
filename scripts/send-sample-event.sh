#!/bin/bash

# go to the C++ simulator directory and build the project
# if folder doesn't exist, exit
SCRIPT_DIR=$(dirname "$0")
cd "$SCRIPT_DIR/../simulator/cpp" || exit
make -s

# execute the simulator and capture the JSON output
JSON_PAYLOAD=$(./device-simulator)

echo "Generated JSON event payload:"
echo "$JSON_PAYLOAD"
echo "---------------------------------"
echo "Sending event to the backend API via HTTP POST..."
curl -X POST http://localhost:8080/api/telemetry \
     -H "Content-Type: application/json" \
     -d "$JSON_PAYLOAD"
echo -e "\n---------------------------------"