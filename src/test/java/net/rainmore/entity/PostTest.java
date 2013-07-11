package net.rainmore.entity;

import junit.framework.Assert;
import net.rainmore.utils.HibernateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostTest {

    protected Logger logger = LogManager.getLogger(this.getClass());
    protected Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @Test
    public void testCreate() {
        Post post = new Post();
        post.setTitle("test");
        post.setContent(" asd fsd fsda fsdaf sad fdsa fasdf");
        post.setPostDate(new DateTime());

        String sql = "TRUNCATE TABLE post";
        Query query = session.createSQLQuery(sql);

        query.executeUpdate();
        session.flush();

        session.saveOrUpdate(post);
        Assert.assertTrue("Id is " + post.getId().toString(), post.getId() == 1);

        post.setTitle(post.getTitle() + " updated ");
        session.save(post);
        Assert.assertTrue("Id is " + post.getId().toString(), post.getId() == 1);
    }

    @After
    public void tearDown() {
        session.getTransaction().commit();
        session.close();
    }
}
