package es.ies.puerto.service.interfaces;

import es.ies.puerto.business.dto.PersonaDTO;

import java.util.List;
/**
 * @author mackstm
 * @author nalleon
 */
public interface IServices <T> {
    public void addToCollection(T t);
    public void updateCollection(T t);
    public List<T> getAllFromCollection();
    public T getByIdFromCollection(int id);
    public void deleteFromCollection(int id);
}
