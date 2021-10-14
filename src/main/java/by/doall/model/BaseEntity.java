package by.doall.model;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    private long id;

    public BaseEntity (long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
