package controller.customer;

import domain.customer.Customer;
import service.customer.FindCustomerService;

public class ListCustomerController {

    public static void listAllCustomer(FindCustomerService findCustomerService) {
        System.out.println("Os clientes são:");
        System.out.println(String.format("%5s %4s %15s %15s", "id", "tipo", "nome", "documento"));
        for (Customer customer : findCustomerService.findAll()) {
            System.out.println(String.format("%5d %4s %15s %15s",
                    customer.getId(),
                    customer.getType().getType(),
                    customer.getName(),
                    customer.getDocument()));
        }
        System.out.println();
    }

    public static boolean hasCustomer(FindCustomerService findCustomerService) {
        return !findCustomerService.findAll().isEmpty();
    }
}
