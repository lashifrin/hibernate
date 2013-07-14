package net.rainmore.common.pager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {

    protected Logger logger = LogManager.getLogger(this.getClass());

    public static Integer DEFAULT_FIRST_PAGE_NUMBER = new Integer(1);
    public static Integer DEFAULT_PAGE_SIZE = new Integer(20);

    protected List<T> list = new ArrayList<T>();

    protected int pageNumber = DEFAULT_FIRST_PAGE_NUMBER;
    protected int pageSize   = DEFAULT_PAGE_SIZE; // -1 to show all

    protected Long count;
    private int first; // first page number
    private int last;  // last page number
    private int prev;
    private int next;

    public Pager(int pageNumber, int pageSize, List<T> list) {
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
        this.setList(list);
    }

    public void init() {
        this.count = new Long(this.getList().size());

        this.first = DEFAULT_FIRST_PAGE_NUMBER;
        this.last = (int) ((this.count / (this.pageSize < 1 ? DEFAULT_PAGE_SIZE : this.pageSize)) + this.first - 1);

        if (this.count % this.pageSize != 0 || this.last == 0) {
            this.last++;
        }

        if (this.last < this.first) {
            this.last = this.first;
        }

        if (this.pageNumber < this.first) {
            this.pageNumber = this.first;
        }

        if (this.pageNumber > this.last) {
            this.pageNumber = this.last;
        }

        this.next = (this.pageNumber < this.last - 1) ? this.pageNumber + 1 : this.last;
        this.prev = (this.pageNumber > this.first) ? this.pageNumber - 1 : this.first;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    public int getPrev() {
        return prev;
    }

    public int getNext() {
        return next;
    }

    public Boolean isFirst() {
        return this.pageNumber == this.first;
    }

    public Boolean isLast() {
        return this.pageNumber == this.last;
    }
}
