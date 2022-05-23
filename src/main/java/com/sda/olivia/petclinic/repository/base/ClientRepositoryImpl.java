package com.sda.olivia.petclinic.repository.base;

import com.sda.olivia.petclinic.model.Client;
import com.sda.olivia.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;


public class ClientRepositoryImpl extends BaseRepositoryImpl<Client, Long> implements ClientRepository {
    public ClientRepositoryImpl() {
        super(Client.class);
    }

    @Override
    public Optional<Client> findByName(String firstName, String lastName) {
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            Query<Client> query = session.createQuery("FROM Client c WHERE c.firstName=:firstName AND " + "c.lastName=:lastName", Client.class);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            List<Client> clients =query.list();


            session.close();
           // return clients.stream().findAny();
            if(clients.isEmpty()){
                return Optional.empty();
            }else{
                return Optional.of(clients.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            ;
            return Optional.empty();
        }
    }

    @Override
    public Optional<Client> findByIdAndLoadPets(Long id) {
        return Optional.empty();
    }

    Optional<Client> findByClientId(Long id){
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            Client client = session.find(Client.class, id);

            session.close();
            // return clients.stream().findAny();
         return Optional.of(client);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            return Optional.empty();
        }
    }
}
