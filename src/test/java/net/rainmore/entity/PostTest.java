package net.rainmore.entity;

import net.rainmore.utils.HibernateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class PostTest {

    protected Logger logger = LogManager.getLogger(this.getClass());


    @Before
    public void setUp() throws Exception {
    }

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
        session.flush();

        session.saveOrUpdate(post);

        logger.info(post.getId() + " asd fasd fdsafsa");
        post.setTitle(post.getTitle() + " adfa sdf sadf sadf ");
        session.save(post);
        logger.info(post.getId() + " asd fasd fdsafsa");
        session.getTransaction().commit();
        session.close();

    }

    @After
    public void tearDown() {
    }
}
