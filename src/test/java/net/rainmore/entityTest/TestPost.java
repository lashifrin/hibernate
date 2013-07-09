package net.rainmore.entityTest;

import net.rainmore.utils.HibernateUtils;
import net.rainmore.entity.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.junit.Test;

public class TestPost {

    protected Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void create() {
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
}
