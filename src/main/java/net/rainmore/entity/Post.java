package net.rainmore.entity;

import net.rainmore.common.DataEntity;
import net.rainmore.common.EntityAuditableInterface;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post")
public class Post extends DataEntity implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(nullable = false, length = 250)
    private String title;

    @Column
    private String content;

    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime postDate;


//    private AuditData auditData = new AuditData();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(DateTime postDate) {
        this.postDate = postDate;
    }

    @PrePersist
    public void prePersist() {
        super.prePersist();
        this.setTitle(this.getTitle() + " " + this.getSysCreatedDate().toString());
    }
}
