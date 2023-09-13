package controller.vehicle;

import domain.vehicle.Vehicle;
import service.vehicle.FindVehicleService;
import utils.InputUtils;

import java.util.List;
import java.util.Scanner;

public class SearchVehicleController {

    private final FindVehicleService findVehicleService;
    private final Scanner scanner;

    public SearchVehicleController(FindVehicleService findVehicleService, Scanner scanner) {
        this.findVehicleService = findVehicleService;
        this.scanner = scanner;
    }

    public void executeSearchVehicle() {
        System.out.println("------------------------------------------");
        System.out.println("Você escolheu opção '5. Buscar um veículo'");
        System.out.println("------------------------------------------");
        System.out.println("Só é possível buscar veículos por parte da placa.");

        if (this.hasVehicle()) {

            String partialLicensePlate = InputUtils.inputString(this.scanner, "Digite parte da placa: ");

            List<Vehicle> vehicles = this.findVehicleService.findByPartialLicensePlate(partialLicensePlate);

            if (vehicles.isEmpty()) {
                System.out.println(String.format("Não foram encontrados veículos que tem '%s' na sua placa",
                        partialLicensePlate));
            } else {
                System.out.println("Os veículos encontrados foram:");
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

        } else {
            System.out.println("Não há veículos cadastrados.");
        }
    }

    private boolean hasVehicle() {
        return !this.findVehicleService.findAll().isEmpty();
    }
}
