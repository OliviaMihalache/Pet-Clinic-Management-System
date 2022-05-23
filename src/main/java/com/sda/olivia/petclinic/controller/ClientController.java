package com.sda.olivia.petclinic.controller;

import com.sda.olivia.petclinic.service.ClientService;
import com.sda.olivia.petclinic.service.ClientServiceImpl;

import java.util.Scanner;

public class ClientController {
    private final ClientService clientService;
    private final Scanner scanner;

    public ClientController() {
        this.clientService = new ClientServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void viewAllPetsForClient() {
        try {
            System.out.println("Please insert client id: ");
            Long clientId = Long.parseLong(scanner.nextLine());
            clientService.findPetsForClientId(clientId).stream()
                    .forEach(pet -> System.out.println(pet));
        } catch (NumberFormatException e) {
            System.out.println(" Please insert a valid client id: ");
        } catch (Exception e) {
            System.out.println(" Internal server error ");
            e.printStackTrace();
        }

    }
}
