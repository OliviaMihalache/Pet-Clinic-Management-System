package com.sda.olivia.petclinic.controller;

import com.sda.olivia.petclinic.service.PetService;
import com.sda.olivia.petclinic.service.PetServiceImpl;
import com.sda.olivia.petclinic.service.dto.PetDto;
import com.sda.olivia.petclinic.service.exception.InvalidParameterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PetController {

    private final PetService petService;
    private final Scanner scanner;
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_FORMAT);

    public PetController() {
        this.petService = new PetServiceImpl();
        scanner = new Scanner(System.in);
    }

    public void addPet() {
//String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName
        try {
            System.out.println("Please insert race");
            String raceInput = scanner.nextLine();

            System.out.println("Please insert date of birth");
            String dateInput = scanner.nextLine();
            Date birthDate = FORMATTER.parse(dateInput);

            System.out.println("Please insert true if the pet is vaccinated or false, otherwise ");
            boolean isVaccinatedState = Boolean.parseBoolean(scanner.nextLine());
            System.out.println("Please insert the owner's first name");
            String firstName = scanner.nextLine();
            System.out.println("Please insert the owner's last name");
            String lastName = scanner.nextLine();

            petService.create(raceInput, birthDate, isVaccinatedState, firstName, lastName);



        } catch (ParseException e) {
            System.out.println("Please insert a correct date of birth " + DATE_FORMAT);
        }catch (InputMismatchException e){
            System.out.println(" Please insert true or false for the vaccinated status");
        }catch (InvalidParameterException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("INTERNAL SERVER ERROR");
        }
    }
    public void showAllVaccinated(){
        petService
                .findAllVaccinated()
                .stream()
                .forEach(pet -> System.out.println("Race: " + pet.getRace() +
                        " Date of birth: " + FORMATTER.format(pet.getDateOfBirth()) + " Is vaccinated " + (pet.getVaccinated()?"YES":"NO")));
    }
    public void showAllPets(){
        List<PetDto> pets = petService.findAll();
        if(pets.isEmpty()){
            System.out.println("No pets");
            return;

        }
        pets.stream().forEach(petDto ->
                System.out.println("\n Id: " + petDto.getId()+
                        "\n: Race "+ petDto.getRace() +
                        " \n: Date of birth: "+petDto.getDateOfBirth()+
                        "\n: IsVaccinated " + petDto.getVaccinated()));
    }
}
