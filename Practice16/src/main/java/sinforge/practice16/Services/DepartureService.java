package sinforge.practice16.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import sinforge.practice16.Entities.Departure;
import sinforge.practice16.Entities.PostOffice;

import java.util.ArrayList;
import java.util.List;

@Component

public class DepartureService {
    private Session session;
    public DepartureService(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public void add(String type, String date, int officeId) {
        Departure departure = new Departure();
        departure.setType(type);
        departure.setDate(date);
        departure.setOffice(session.load(PostOffice.class, officeId));
        var transaction = session.beginTransaction();
        session.saveOrUpdate(departure);
        transaction.commit();

    }
    public void delete(String type, String date) {

        var transaction = session.beginTransaction();
        String hql = "delete from Departure where type= :type and date= :date";
        session.createQuery(hql).setString("type", type).setString("date", date).executeUpdate();
        transaction.commit();
    }

    public List<Departure> getAll() {
        return session.createQuery("select d from Departure d",
                Departure.class).getResultList();
    }


}
