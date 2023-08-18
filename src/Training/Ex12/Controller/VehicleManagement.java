package src.Training.Ex12.Controller;

import src.Training.Ex12.Model.Vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VehicleManagement {
    List<Vehicles> vehiclesList = new ArrayList<>();

    public void addVehicles(Vehicles vehicles) {
        vehiclesList.add(vehicles);
    }

    public void deleteVehicles(String id) {
        Optional<Vehicles> vehicles = vehiclesList.stream()
                .filter(vehicles1 -> vehicles1.getId().equals(id)).findFirst();
        if (vehicles.isPresent()) {
            vehiclesList.remove(vehicles);
        }
    }

    public List<Vehicles> searchForManufacturerAndColor(String manufacturer, String color) {
        return vehiclesList.stream()
                .filter(vehicles -> vehicles.getManufacturer().equals(manufacturer) && vehicles.getColor().equals(color))
                .collect(Collectors.toList());
    }

    public void showVehiclesInfo() {
        vehiclesList.forEach(vehicles -> System.out.println(vehicles.toString()));
    }
}
