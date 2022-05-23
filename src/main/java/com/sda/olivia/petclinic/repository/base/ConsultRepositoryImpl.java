package com.sda.olivia.petclinic.repository.base;

import com.sda.olivia.petclinic.model.Consult;
import com.sda.olivia.petclinic.utils.SessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultRepositoryImpl extends BaseRepositoryImpl<Consult, Long> implements ConsultRepository {
    public ConsultRepositoryImpl() {
        super(Consult.class);
    }

    @Override
    public List<Consult> findAllUnvaccinatedPets() {
        try{
            Session session = SessionManager.getSessionFactory().openSession();
            List<Consult> consults = session.createQuery("FROM Consult c WHERE c.pet.isVaccinated = false", Consult.class).list();

            session.close();
            return consults;
        }catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }


    }
    public List<Consult> findAllByVetIdAndDateBetween(Long vetId, Date startDate, Date endDate){
        try{
            Session  session = SessionManager.getSessionFactory().openSession();
            Query<Consult> query= session.createQuery
                    ("FROM Consult c " +
                            "WHERE c.veterinarianId=:vetId " +
                            "AND c.date BETWEEN : startDate and :endDate", Consult.class);
            query.setParameter("vetId ", vetId);
            query.setParameter("startDate ", startDate);
            query.setParameter("endDate ", endDate);
            List<Consult> consults = query.list();






            session.close();
            return consults;

        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
