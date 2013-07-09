package net.rainmore.entity;

import net.rainmore.utils.HibernateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PostTest {

    protected Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testCreate() {
        Post post = new Post();
        post.setTitle("test");
        post.setContent(" asd fsd fsda fsdaf sad fdsa fasdf");
        post.setPostDate(new DateTime());

        Session session = HibernateUtils
                .getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "TRUNCATE TABLE post";
        Query query = session.createSQLQuery(sql);

        query.executeUpdate();

        logger.info(" asd fasd fdsa");
        session.saveOrUpdate(post);
        logger.info(post.getId() + " asd fasd fdsafsa");
        post.setTitle(post.getTitle() + " adfa sdf sadf sadf ");
        session.save(post);

        logger.info(post.getId() + " asd fasd fdsafsa");
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void testEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager();

        Post post = new Post();
        post.setTitle("test 2");
        post.setContent(" asd fsd fsda fsdaf sad fdsa fasdf");
        post.setPostDate(new DateTime());

        em.persist(post);
        em.flush(); // force the SQL insert and triggers to run
        em.refresh(post); //re-read the state (after the trigger executes)

        logger.info("post id: " + post.getId().toString());

        em.close();
        emf.close();
    }
}
