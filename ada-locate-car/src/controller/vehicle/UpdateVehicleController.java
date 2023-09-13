package controller.vehicle;

import domain.vehicle.Vehicle;
import service.vehicle.FindVehicleService;
import service.vehicle.UpdateVehicleService;
import utils.InputUtils;
import utils.ValidationUtils;

import java.util.Scanner;

public class UpdateVehicleController {

    private final FindVehicleService findVehicleService;
    private final UpdateVehicleService updateVehicleService;
    private final Scanner scanner;

    public UpdateVehicleController(FindVehicleService findVehicleService,
                                   UpdateVehicleService updateVehicleService, Scanner scanner) {
        this.findVehicleService = findVehicleService;
        this.updateVehicleService = updateVehicleService;
        this.scanner = scanner;
    }

    public void executeUpdateVehicle() {
        System.out.println("------------------------------------------");
        System.out.println("Você escolheu opção '4. Alterar cadastro de um veículo'");
        System.out.println("------------------------------------------");
        System.out.println("Só é possível alterar o fabricante e o ano de fabricação do veículo.");

        if (ListVehicleController.hasVehicle(this.findVehicleService)) {
            ListVehicleController.listAllVehicle(this.findVehicleService);

            Integer id = InputUtils.inputInt(this.scanner, "Escolha o id do veículo cujo dado queira alterar: ");

            String maker = InputUtils.inputString(this.scanner, "Digite o fabricante do veículo: ");

            String year = InputUtils.inputString(this.scanner, "Digite o ano em que o veículo foi fabricado: ");

            Vehicle updatedVehicle = this.updateVehicleService.update(id, maker, year);

            ValidationUtils.validadeIsNull(updatedVehicle,
                    String.format("Não foi possível alterar o veículo com id %d inválido.", id),
                    String.format("O veículo com id %d foi atualizado com sucesso.", id));
        } else {
            System.out.println("Não há veículos cadastrados.");
        }
    }
}
