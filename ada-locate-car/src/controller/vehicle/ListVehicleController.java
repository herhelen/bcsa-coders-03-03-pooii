package controller.vehicle;

import domain.vehicle.Vehicle;
import service.vehicle.FindVehicleService;

public class ListVehicleController {

    public static void listAllVehicle(FindVehicleService findVehicleService) {
        System.out.println("Os veículos são:");
        System.out.println(String.format("%5s %8s %15s %15s %4s", "id", "tipo", "placa", "fabricante", "ano"));
        for (Vehicle vehicle : findVehicleService.findAll()) {
            System.out.println(String.format("%5d %8s %15s %15s %4s",
                    vehicle.getId(),
                    vehicle.getType().getType(),
                    vehicle.getLicensePlate(),
                    vehicle.getMaker(),
                    vehicle.getYear()));
        }
        System.out.println();
    }

    public static boolean hasVehicle(FindVehicleService findVehicleService) {
        return !findVehicleService.findAll().isEmpty();
    }
}
