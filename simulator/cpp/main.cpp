#include <iostream>
#include <cstdlib>
#include <ctime>

int main () {
	std::srand(std::time(0));

	double temp = 40.0 + (std::rand() % 100) / 10.0; // Values between 40.0 and 49.9 degrees
	double voltage = 12.0 + (std::rand() % 10) / 10.0; // Values between 12.0 and 12.9 volts
	int battery = 80 + (std::rand() % 21); // Value between 80 and 100
					    
	// Print the JSON on the stout
	std::cout << "{\n";
    std::cout << "  \"device_id\": \"device-001\",\n";
    std::cout << "  \"temperature_c\": " << temp << ",\n";
    std::cout << "  \"voltage_v\": " << voltage << ",\n";
    std::cout << "  \"battery_percent\": " << battery << ",\n";
    std::cout << "  \"machine_state\": \"RUNNING\",\n";
    std::cout << "  \"error_code\": null\n";
    std::cout << "}\n";
}
