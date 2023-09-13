package controller.vehicle;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleType;
import service.vehicle.RegisterVehicleService;
import utils.InputUtils;
import utils.ValidationUtils;

import java.util.Scanner;

public class RegisterVehicleController {

    private final RegisterVehicleService registerVehicleService;
    private final Scanner scanner;

    public RegisterVehicleController(RegisterVehicleService registerVehicleService, Scanner scanner) {
        this.registerVehicleService = registerVehicleService;
        this.scanner = scanner;
    }

    public void executeRegisterVehicle() {
        System.out.println("------------------------------------------");
        System.out.println("Você escolheu opção '2. Cadastrar veículo'");
        System.out.println("------------------------------------------");

        System.out.println("Os tipos de veículos são:");
        for (VehicleType vehicleType : VehicleType.values()) {
            System.out.println(String.format("%d - %s", vehicleType.getId(), vehicleType.getType()));
        }

        Integer idVehicleType = InputUtils.inputInt(this.scanner,
                "Escolha o tipo de veículo que deseja cadastrar: ",
                VehicleType.ids(),
                "Tipo de veículo inválido.");
        VehicleType type = VehicleType.idToEnum(idVehicleType);

        String licensePlate = InputUtils.inputString(this.scanner, "Digite a placa do veículo: ");

        String maker = InputUtils.inputString(this.scanner, "Digite o fabricante do veículo: ");

        String year = InputUtils.inputString(this.scanner, "Digite o ano em que o veículo foi fabricado: ");

        Vehicle newVehicle = this.registerVehicleService.register(type, licensePlate, maker, year);

        ValidationUtils.validadeIsNull(newVehicle,
                String.format("Não foi possível cadastrar o veículo com placa '%s', " +
                        "pois já existe um veículo com a mesma placa", licensePlate),
                String.format("Novo veículo '%s' cadastrado com sucesso!", licensePlate));
    }
}
