package sinforge.practice17.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import sinforge.practice17.Entities.Departure;
import sinforge.practice17.Entities.PostOffice;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public List<Departure> filterByType(String type) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Departure> queryCriteriaQuery = builder.createQuery(Departure.class);
        Root<Departure> root = queryCriteriaQuery.from(Departure.class);

        queryCriteriaQuery.select(root).where(builder.equal(root.get("type"), type));
        return session.createQuery(queryCriteriaQuery).getResultList();
    }
    public List<Departure> filterByDate(String date) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Departure> postOfficeCriteriaQuery = builder.createQuery(Departure.class);
        Root<Departure> root = postOfficeCriteriaQuery.from(Departure.class);

        postOfficeCriteriaQuery.select(root).where(builder.equal(root.get("date"), date));
        return session.createQuery(postOfficeCriteriaQuery).getResultList();
    }



}
