package com.sda.olivia.petclinic;

import com.sda.olivia.petclinic.controller.VeterinarianController;
import com.sda.olivia.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory().openSession();
        VeterinarianController veterinarianController = new VeterinarianController();
        veterinarianController.create();

    }
}
