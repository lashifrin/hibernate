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

    }

    @Test
    public void testCreate() {
        session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
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

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testCreate1() {

        Post post = new Post();
        post.setTitle("test");

        session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(post);

        Post post1 = (Post) session.get(Post.class, post.getId());
        Assert.assertEquals(post1.getTitle(), post.getTitle());

        logger.info(post1.getTitle());
        logger.info(post.getTitle());

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void tearDown() {

    }
}
