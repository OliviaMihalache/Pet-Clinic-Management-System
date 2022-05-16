package com.sda.olivia.petclinic;

import com.sda.olivia.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {

        //Temporary change until we have the Repository implementation
        SessionManager.getSessionFactory().openSession();

    }
}
