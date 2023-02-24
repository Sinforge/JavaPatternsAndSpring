package sinforge.practice15.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import sinforge.practice15.Entities.Departure;
import sinforge.practice15.Entities.PostOffice;

import javax.persistence.Query;
import java.util.List;

@Component
public class PostOfficeService {
    private Session session;
    public PostOfficeService(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public void add(String name, String city) {
        PostOffice postOffice = new PostOffice();
        postOffice.setName(name);
        postOffice.setCityName(city);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(postOffice);
        transaction.commit();

    }
    public void delete(String name, String city) {

        var transaction = session.beginTransaction();
        String hql = "delete from PostOffice where name= :name and cityName= :cityname";
        session.createQuery(hql).setString("name", name).setString("cityname", city).executeUpdate();
        transaction.commit();
    }

    public List<PostOffice> getAll() {
        return session.createQuery("select p from PostOffice p",
                PostOffice.class).getResultList();
    }

}
