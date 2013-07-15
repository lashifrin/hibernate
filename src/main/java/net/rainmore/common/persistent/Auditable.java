package net.rainmore.common.persistent;

public interface Auditable {
    public void prePersist();
    public void preUpdate();
}
