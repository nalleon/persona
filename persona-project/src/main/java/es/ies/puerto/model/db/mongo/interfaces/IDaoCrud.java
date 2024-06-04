package es.ies.puerto.model.db.mongo.interfaces;
import java.util.Set;

public interface IDaoCrud  <T> {
    Set<T> obtainAllObjects();

    T obtainObject(T t);

    boolean addObject(T t);

    boolean removeObject(T t);

    default boolean updateObject(T t){
        return false;
    }
}