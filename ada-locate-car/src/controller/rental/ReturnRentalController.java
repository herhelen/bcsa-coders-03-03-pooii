package controller.rental;

import domain.rental.Rental;
import service.customer.FindCustomerService;
import service.rental.CalculateRentalService;
import service.rental.FindRentalService;
import service.rental.ReturnRentalService;
import service.vehicle.FindVehicleService;
import utils.InputUtils;
import utils.ValidationUtils;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ReturnRentalController {

    private final FindCustomerService findCustomerService;
    private final FindVehicleService findVehicleService;
    private final FindRentalService findRentalService;
    private final ReturnRentalService returnRentalService;
    private final CalculateRentalService calculateRentalService;
    private final Scanner scanner;

    public ReturnRentalController(FindCustomerService findCustomerService, FindVehicleService findVehicleService,
                                  FindRentalService findRentalService, ReturnRentalService returnRentalService,
                                  CalculateRentalService calculateRentalService, Scanner scanner) {
        this.findCustomerService = findCustomerService;
        this.findVehicleService = findVehicleService;
        this.findRentalService = findRentalService;
        this.returnRentalService = returnRentalService;
        this.calculateRentalService = calculateRentalService;
        this.scanner = scanner;
    }

    public void executeReturnRental() {
        System.out.println("------------------------------------------");
        System.out.println("Você escolheu opção '7. Devolver um veículo'");
        System.out.println("------------------------------------------");

        if (ListRentalController.hasUnreturnedRental(this.findRentalService)) {
            ListRentalController.listUnreturnedVehicle(this.findRentalService,
                    this.findCustomerService, this.findVehicleService);

            Integer idRental = InputUtils.inputInt(this.scanner,
                    "Escolha o id do aluguel do veículo que deseja devolver: ");

            LocalDateTime endDateTime = InputUtils.inputDateTime(
                    this.scanner,
                    "dd/MM/yyyy H:m",
                    "Digite a data e o horário final do aluguel do veículo no formato 'dd/mm/aaaa hh:mm': ",
                    "Data inválida. O formato aceito é dd/mm/aaaa hh:mm, por exemplo 17/08/2023 14:23."
            );

            String endPlace = InputUtils.inputString(this.scanner,
                    "Digite o lugar final do aluguel do veículo: ");

            Rental returnedRental = this.returnRentalService.returnVehicle(idRental, endDateTime, endPlace);

            ValidationUtils.validadeIsNull(returnedRental,
                    String.format("Não foi possível devolver o veículo com alguel id %d.", idRental),
                    String.format("O veículo devolvido com sucesso."));
        } else {
            System.out.println("Não há veículos alugados a serem devolvidos.");
        }
    }
}
