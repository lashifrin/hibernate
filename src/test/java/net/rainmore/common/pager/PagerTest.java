package net.rainmore.common.pager;

import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PagerTest {

    protected Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testPager() {

        Pager<Integer> pager1 = new Pager<Integer>(1, 20, new ArrayList<Integer>(5));
        pager1.init();
        Assert.assertEquals(pager1.getFirst(), 1);
        Assert.assertEquals(pager1.getLast(), 1);
        Assert.assertEquals(pager1.getNext(), 1);
        Assert.assertEquals(1, pager1.getPrev());


        pager1.setPageNumber(2);
        pager1.init();
        Assert.assertEquals(pager1.getFirst(), 1);
        Assert.assertEquals(pager1.getLast(), 1);
        Assert.assertEquals(pager1.getNext(), 1);
        Assert.assertEquals(1, pager1.getPrev());

        List<Integer> list2 = new ArrayList<>();

        for(int i = 0; i < 101; i++) {
            list2.add(new Integer(i + 1));
        }


        pager1.setList(list2);
        pager1.setPageNumber(2);
        pager1.init();
        Assert.assertEquals(1, pager1.getFirst(), 1);
        Assert.assertEquals(6, pager1.getLast(), 6);
        Assert.assertEquals(3, pager1.getNext());
        Assert.assertEquals(1, pager1.getPrev());


        pager1.setPageNumber(6);
        pager1.init();
        logger.info(pager1.getPageSize());
        logger.info(pager1.getPageNumber());
        logger.info(pager1.getCount().toString());
        Assert.assertEquals(1, pager1.getFirst());
        Assert.assertEquals(6, pager1.getLast());
        Assert.assertEquals(6, pager1.getNext());
        Assert.assertEquals(5, pager1.getPrev());

        pager1.setList(list2);
        pager1.setPageNumber(7);
        pager1.init();
        Assert.assertEquals(1, pager1.getFirst(), 1);
        Assert.assertEquals(6, pager1.getLast(), 6);
        Assert.assertEquals(6, pager1.getNext());
        Assert.assertEquals(5, pager1.getPrev());

        pager1.setList(list2);
        pager1.setPageNumber(0);
        pager1.init();
        Assert.assertEquals(1, pager1.getFirst(), 1);
        Assert.assertEquals(6, pager1.getLast(), 6);
        Assert.assertEquals(2, pager1.getNext());
        Assert.assertEquals(1, pager1.getPrev());

    }
}
