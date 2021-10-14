package by.doall.repository;

import by.doall.model.BaseEntity;
import java.util.List;
import java.util.Arrays;

public abstract class BaseEntityRepository<T extends BaseEntity> {

   public abstract T getById(long id);

   // public abstract void deleteById(long id);

   // public abstract T update(T entity);

   // public abstract List<T> getAll();



}
