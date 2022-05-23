package com.sda.olivia.petclinic;

import com.sda.olivia.petclinic.controller.ClientController;
import com.sda.olivia.petclinic.controller.ConsultController;
import com.sda.olivia.petclinic.controller.PetController;
import com.sda.olivia.petclinic.controller.VeterinarianController;
import com.sda.olivia.petclinic.option.UserOption;
import com.sda.olivia.petclinic.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory().openSession();
        VeterinarianController veterinarianController = new VeterinarianController();
        PetController petController = new PetController();
        ClientController clientController = new ClientController();
        ConsultController consultController = new ConsultController();
        UserOption option = UserOption.UNKNOWN;
        Scanner scanner = new Scanner(System.in);
        do {
            UserOption.printAllOptions();
            System.out.println("Choose an option");
            String inputOption = scanner.nextLine();
            try {
                int userOption = Integer.parseInt(inputOption);
                option = UserOption.findBy(userOption).orElse(UserOption.UNKNOWN);
            } catch (NumberFormatException e) {
                option = UserOption.UNKNOWN;
            }
            System.out.println(option.getPrettyName());
            switch (option) {
                case ADD_NEW_VET:
                    veterinarianController.create();
                    break;
                case SHOW_ALL:
                    veterinarianController.showAllVeterinarians();
                    break;
                case DELETE_BY_ID:
                    veterinarianController.deleteById();
                    break;
                case UPDATE:
                    veterinarianController.update();
                    break;
                case ADD_NEW_PET:
                    petController.addPet();
                    break;
                case VIEW_ALL_VACCINATED:
                    petController.showAllVaccinated();
                    break;
                case VIEW_ALL_PETS_FOR_CLIENT_ID:
                    clientController.viewAllPetsForClient();
                    break;
                case SHOW_ALL_PETS:
                    petController.showAllPets();
                    break;
                case DELETE_PETS_BY_ID:
                    petController.deletePetsById();
                    break;
                case ADD_NEW_CONSULT:
                    consultController.create();
                    break;
                case SHOW_ALL_CONSULTS_WITH_UNVACCINATED_PETS:
                    consultController.viewAllUnvaccinatedPets();
                    break;
                case UNKNOWN:
                    break;
                case EXIT:
                    System.out.println("GOODBYE");
                    break;
                default:
                    System.out.println("This option is not implemented.");
                    break;
            }
        } while (!option.equals(UserOption.EXIT));
        SessionManager.shutdown();
    }


}

