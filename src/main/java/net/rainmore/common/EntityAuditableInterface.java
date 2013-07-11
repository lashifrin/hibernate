package net.rainmore.common;

public interface EntityAuditableInterface {
    public void prePersist();
    public void preUpdate();
}
