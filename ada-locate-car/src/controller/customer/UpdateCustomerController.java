package controller.customer;

import domain.customer.Customer;
import service.customer.FindCustomerService;
import service.customer.UpdateCustomerService;
import utils.InputUtils;
import utils.ValidationUtils;

import java.util.Scanner;

public class UpdateCustomerController {

    private final FindCustomerService findCustomerService;
    private final UpdateCustomerService updateCustomerService;
    private final Scanner scanner;

    public UpdateCustomerController(FindCustomerService findCustomerService,
                                    UpdateCustomerService updateCustomerService, Scanner scanner) {
        this.findCustomerService = findCustomerService;
        this.updateCustomerService = updateCustomerService;
        this.scanner = scanner;
    }

    public void executeUpdateCustomer() {
        System.out.println("------------------------------------------");
        System.out.println("Você escolheu opção '3. Alterar cadastro de um cliente'");
        System.out.println("------------------------------------------");
        System.out.println("Só é possível alterar o nome do cliente.");

        if (ListCustomerController.hasCustomer(this.findCustomerService)) {
            ListCustomerController.listAllCustomer(this.findCustomerService);

            Integer id = InputUtils.inputInt(this.scanner, "Escolha o id do cliente cujo nome queira alterar: ");

            String name = InputUtils.inputString(this.scanner, "Digite o nome novo do cliente: ");

            Customer updatedCustomer = this.updateCustomerService.update(id, name);

            ValidationUtils.validadeIsNull(updatedCustomer,
                    String.format("Não foi possível alterar o cliente com id %d inválido.", id),
                    String.format("O nome do cliente '%s' alterado com sucesso!", name));
        } else {
            System.out.println("Não há clientes cadastrados.");
        }
    }
}
