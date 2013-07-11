package net.rainmore.common;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


@MappedSuperclass
public class DataEntity extends BaseEntity implements EntityAuditableInterface {

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column
    protected DateTime sysUpdatedDate;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column
    protected DateTime sysCreatedDate;

    @PrePersist
    public void prePersist() {
        DateTime dateTime = new DateTime();
        setSysCreatedDate(dateTime);
        setSysUpdatedDate(dateTime);
        System.out.println(getSysCreatedDate().toString());
        System.out.println(getSysUpdatedDate().toString());
    }

    @PreUpdate
    public void preUpdate() {
        setSysUpdatedDate(new DateTime());
        System.out.println(getSysCreatedDate().toString());
        System.out.println(getSysUpdatedDate().toString());
    }

    public DateTime getSysCreatedDate() {
        return sysCreatedDate;
    }

    public void setSysCreatedDate(DateTime sysCreatedDate) {
        this.sysCreatedDate = sysCreatedDate;
    }

    public DateTime getSysUpdatedDate() {
        return sysUpdatedDate;
    }

    public void setSysUpdatedDate(DateTime sysUpdatedDate) {
        this.sysUpdatedDate = sysUpdatedDate;
    }
}
