package controller.vehicle;

import domain.vehicle.Vehicle;
import service.vehicle.FindVehicleService;

import java.util.List;

public class ListVehicleController {

    private static void printListVehicle(List<Vehicle> vehicles, String initialMsg) {
        System.out.println(initialMsg);
        System.out.println(String.format("%5s %8s %15s %15s %4s", "id", "tipo", "placa", "fabricante", "ano"));
        for (Vehicle vehicle : vehicles) {
            System.out.println(String.format("%5d %8s %15s %15s %4s",
                    vehicle.getId(),
                    vehicle.getType().getType(),
                    vehicle.getLicensePlate(),
                    vehicle.getMaker(),
                    vehicle.getYear()));
        }
        System.out.println();
    }

    public static void listAllVehicle(FindVehicleService findVehicleService) {
        printListVehicle(findVehicleService.findAll(), "Os veículos são:");
    }

    public static void listAvailableVehicle(FindVehicleService findVehicleService) {
        printListVehicle(findVehicleService.findAvailableVehicle(),
                "Os veículos disponíveis para alugar são:");
    }

    public static boolean hasVehicle(FindVehicleService findVehicleService) {
        return !findVehicleService.findAll().isEmpty();
    }

    public static boolean hasAvailableVehicle(FindVehicleService findVehicleService) {
        return !findVehicleService.findAvailableVehicle().isEmpty();
    }
}
