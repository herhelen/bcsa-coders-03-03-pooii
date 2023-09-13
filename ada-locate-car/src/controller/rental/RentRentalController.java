package controller.rental;

import controller.customer.ListCustomerController;
import controller.vehicle.ListVehicleController;
import domain.rental.Rental;
import service.customer.FindCustomerService;
import service.rental.RentRentalService;
import service.vehicle.FindVehicleService;
import utils.InputUtils;
import utils.ValidationUtils;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RentRentalController {

    private final FindCustomerService findCustomerService;
    private final FindVehicleService findVehicleService;
    private final RentRentalService rentRentalService;
    private final Scanner scanner;

    public RentRentalController(FindCustomerService findCustomerService, FindVehicleService findVehicleService,
                                RentRentalService rentRentalService, Scanner scanner) {
        this.findCustomerService = findCustomerService;
        this.findVehicleService = findVehicleService;
        this.rentRentalService = rentRentalService;
        this.scanner = scanner;
    }

    public void executeRent() {
        System.out.println("------------------------------------------");
        System.out.println("Você escolheu opção '6. Alugar um veículo'");
        System.out.println("------------------------------------------");

        if (ListCustomerController.hasCustomer(this.findCustomerService) &&
            ListVehicleController.hasAvailableVehicle(this.findVehicleService)
        ) {
            ListCustomerController.listAllCustomer(this.findCustomerService);

            Integer idCustomer = InputUtils.inputInt(this.scanner,
                    "Escolha o id do cliente que vai alugar o veículo: ");

            ListVehicleController.listAvailableVehicle(this.findVehicleService);

            Integer idVehicle = InputUtils.inputInt(this.scanner,
                    "Escolha o id do veículo que o cliente deseja alugar: ");

            LocalDateTime startDateTime = InputUtils.inputDateTime(
                    this.scanner,
                    "dd/MM/yyyy H:m",
                    "Digite a data e o horário inicial do aluguel do veículo no formato 'dd/mm/aaaa hh:mm': ",
                    "Data inválida. O formato aceito é dd/mm/aaaa hh:mm, por exemplo 17/08/2023 14:23."
            );

            String startPlace = InputUtils.inputString(this.scanner,
                    "Digite o lugar inicial do aluguel do veículo: ");

            Rental newRental = this.rentRentalService.rent(idVehicle, idCustomer, startDateTime, startPlace);

            ValidationUtils.validadeIsNull(newRental,
                    String.format("Não foi possível alugar o veículo com id %d.", idVehicle),
                    String.format("O alguel do veículo feito com sucesso."));
        } else {
            System.out.println("Verifique se há clientes e veículos cadastrados.");
        }
    }
}
