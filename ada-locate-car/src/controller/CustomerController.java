package controller;

import domain.customer.Customer;
import domain.customer.CustomerType;
import service.customer.RegisterCustomerService;
import utils.InputUtils;

import java.util.Scanner;

public class CustomerController {

    private final RegisterCustomerService registerCustomerService;
    private final Scanner scanner;

    public CustomerController(RegisterCustomerService registerCustomerService, Scanner scanner) {
        this.registerCustomerService = registerCustomerService;
        this.scanner = scanner;
    }

    public void executeRegisterCustomer() {
        System.out.println("------------------------------------------");
        System.out.println("Você escolheu opção '1. Cadastrar cliente'");
        System.out.println("------------------------------------------");

        System.out.println("Os tipos de clientes são:");
        for (CustomerType type: CustomerType.values()) {
            System.out.println(String.format("%d - %s", type.getId(), type.getType()));
        }
        int idCustomerType =
                InputUtils.inputInt(this.scanner, "Escolha o tipo de cliente que deseja cadastrar: ");
        CustomerType type = CustomerType.idToEnum(idCustomerType);

        String document = InputUtils.inputString(this.scanner, "Digite o documento do cliente: ");

        String name = InputUtils.inputString(this.scanner, "Digite o nome do cliente: ");

        // TODO: documento é único! => Exception!
        Customer newCustomer = this.registerCustomerService.register(type, document, name);

        System.out.println(String.format("Novo cliente '%s' cadastrado com id %d com sucesso!",
                newCustomer.getName(), newCustomer.getId()));
    }
}
