package net.rainmore.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class DataEntity {
    @Transient
    protected Logger logger = LogManager.getLogger(this.getClass());
}
