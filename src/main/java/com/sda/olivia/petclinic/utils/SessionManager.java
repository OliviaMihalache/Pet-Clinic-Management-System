package com.sda.olivia.petclinic.utils;


import com.sda.olivia.petclinic.model.Client;
import com.sda.olivia.petclinic.model.Consult;
import com.sda.olivia.petclinic.model.Pet;
import com.sda.olivia.petclinic.model.Veterinarian;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager(){
    }


    public static SessionFactory getSessionFactory(){
        return INSTANCE.getSessionFactory("pet_clinic");
    }

    public static void shutdown(){
        INSTANCE.shutdownSessionManager();
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(Veterinarian.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Pet.class);
        configuration.addAnnotatedClass(Consult.class);



    }
}
