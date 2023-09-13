package controller;

import domain.customer.Customer;
import domain.rental.Rental;
import domain.vehicle.Vehicle;
import repository.CustomerRepositoryInMemory;
import repository.RentalRepositoryInMemory;
import repository.Repository;
import repository.VehicleRepositoryInMemory;
import service.customer.FindCustomerService;
import service.customer.RegisterCustomerService;
import service.customer.UpdateCustomerService;
import service.rental.CalculateRentalService;
import service.rental.FindRentalService;
import service.rental.RentRentalService;
import service.rental.ReturnRentalService;
import service.vehicle.FindVehicleService;
import service.vehicle.RegisterVehicleService;
import service.vehicle.UpdateVehicleService;
import utils.InputUtils;

import java.util.Scanner;

public class MenuController {

    private final Repository<Vehicle> vehicleRepository;
    private final Repository<Customer> customerRepository;
    private final Repository<Rental> rentalRepository;

    private final FindVehicleService findVehicleService;
    private final RegisterVehicleService registerVehicleService;
    private final UpdateVehicleService updateVehicleService;

    private final FindCustomerService findCustomerService;
    private final RegisterCustomerService registerCustomerService;
    private final UpdateCustomerService updateCustomerService;

    private final FindRentalService findRentalService;
    private final RentRentalService rentRentalService;
    private final ReturnRentalService returnRentalService;
    private final CalculateRentalService calculateRentalService;

    private final Scanner scanner;

    private final RegisterCustomerController registerCustomerController;
    private final UpdateCustomerController updateCustomerController;
    private final RegisterVehicleController registerVehicleController;

    public MenuController() {
        this.vehicleRepository = new VehicleRepositoryInMemory();
        this.customerRepository = new CustomerRepositoryInMemory();
        this.rentalRepository = new RentalRepositoryInMemory();

        this.findVehicleService = new FindVehicleService(this.vehicleRepository);
        this.registerVehicleService = new RegisterVehicleService(this.vehicleRepository, this.findVehicleService);
        this.updateVehicleService = new UpdateVehicleService(this.vehicleRepository, this.findVehicleService);

        this.findCustomerService = new FindCustomerService(this.customerRepository);
        this.registerCustomerService = new RegisterCustomerService(this.customerRepository, this.findCustomerService);
        this.updateCustomerService = new UpdateCustomerService(this.customerRepository, this.findCustomerService);

        this.findRentalService = new FindRentalService(this.rentalRepository);
        this.rentRentalService = new RentRentalService(this.rentalRepository, this.updateVehicleService);
        this.returnRentalService = new ReturnRentalService(this.rentalRepository, this.updateVehicleService);
        this.calculateRentalService = new CalculateRentalService(this.rentalRepository, this.findRentalService,
                this.findVehicleService, this.findCustomerService);

        this.scanner = new Scanner(System.in);

        this.registerCustomerController = new RegisterCustomerController(this.registerCustomerService, this.scanner);
        this.updateCustomerController = new UpdateCustomerController(this.findCustomerService,
                this.updateCustomerService, this.scanner);

        this.registerVehicleController = new RegisterVehicleController(this.registerVehicleService, this.scanner);
    }

    public void mainMenu() {
        int option = -1;

        while (option != 0) {
            printMainMenu();
            option = InputUtils.inputInt(this.scanner);
            executeMainMenu(option);
        }

        this.scanner.close();
    }

    private void printMainMenu() {
        System.out.println("------------------------------------------");
        System.out.println("Escolha uma das opções a seguir:");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Cadastrar veículo");
        System.out.println("3. Alterar cadastro de um cliente");
        System.out.println("4. Alterar cadastro de um veículo");
        System.out.println("5. Buscar um veículo");
        System.out.println("6. Alugar um veículo");
        System.out.println("7. Devolver um veículo");
        System.out.println("0. Sair");
        System.out.println("------------------------------------------");
    }

    private void executeMainMenu(int option) {
        switch (option) {
            case 0 -> System.out.println("Até a próxima!");
            case 1 -> this.registerCustomerController.executeRegisterCustomer();
            case 2 -> this.registerVehicleController.executeRegisterVehicle();
            case 3 -> this.updateCustomerController.executeUpdateCustomer();
            case 4 -> System.out.println(option);
            case 5 -> System.out.println(option);
            case 6 -> System.out.println(option);
            case 7 -> System.out.println(option);
        }
    }

}
