package controller;

import domain.customer.Customer;
import domain.customer.CustomerType;
import service.customer.RegisterCustomerService;
import utils.InputUtils;
import utils.ValidationUtils;

import java.util.Scanner;

public class RegisterCustomerController {

    private final RegisterCustomerService registerCustomerService;
    private final Scanner scanner;

    public RegisterCustomerController(RegisterCustomerService registerCustomerService, Scanner scanner) {
        this.registerCustomerService = registerCustomerService;
        this.scanner = scanner;
    }

    public void executeRegisterCustomer() {
        System.out.println("------------------------------------------");
        System.out.println("Você escolheu opção '1. Cadastrar cliente'");
        System.out.println("------------------------------------------");

        System.out.println("Os tipos de clientes são:");
        for (CustomerType cType : CustomerType.values()) {
            System.out.println(String.format("%d - %s", cType.getId(), cType.getType()));
        }

        Integer idCustomerType = InputUtils.inputInt(this.scanner,
                "Escolha o tipo de cliente que deseja cadastrar: ",
                CustomerType.ids(),
                "Tipo de cliente inválido.");
        CustomerType type = CustomerType.idToEnum(idCustomerType);

        String document = InputUtils.inputString(this.scanner, "Digite o documento do cliente: ");

        String name = InputUtils.inputString(this.scanner, "Digite o nome do cliente: ");

        Customer newCustomer = this.registerCustomerService.register(type, document, name);

        ValidationUtils.validadeIsNull(newCustomer,
                String.format("Não foi possível cadastrar o cliente '%s' com documento '%s', " +
                        "pois já existe um cliente com o mesmo documento", name, document),
                String.format("Novo cliente '%s' cadastrado com sucesso!", name));
    }
}
