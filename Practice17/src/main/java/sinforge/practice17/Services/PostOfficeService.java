package sinforge.practice17.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import sinforge.practice17.Entities.PostOffice;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        postOffice.setCityname(city);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(postOffice);
        transaction.commit();

    }
    public void delete(String name, String city) {

        var transaction = session.beginTransaction();
        String hql = "delete from PostOffice where name= :name and cityname= :cityname";
        session.createQuery(hql).setString("name", name).setString("cityname", city).executeUpdate();
        transaction.commit();
    }

    public List<PostOffice> getAll() {
        return session.createQuery("select p from PostOffice p",
                PostOffice.class).getResultList();
    }

    public List<PostOffice> filterByName(String name) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PostOffice> postOfficeCriteriaQuery = builder.createQuery(PostOffice.class);
        Root<PostOffice> root = postOfficeCriteriaQuery.from(PostOffice.class);

        postOfficeCriteriaQuery.select(root).where(builder.equal(root.get("name"), name));
        return session.createQuery(postOfficeCriteriaQuery).getResultList();
    }
    public List<PostOffice> filterByCity(String city) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PostOffice> postOfficeCriteriaQuery = builder.createQuery(PostOffice.class);
        Root<PostOffice> root = postOfficeCriteriaQuery.from(PostOffice.class);

        postOfficeCriteriaQuery.select(root).where(builder.equal(root.get("city"), city));
        return session.createQuery(postOfficeCriteriaQuery).getResultList();
    }
}
