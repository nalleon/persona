package es.ies.puerto.service.interfaces;

import es.ies.puerto.business.dto.PersonaDTO;

import java.util.List;
/**
 * @author mackstm
 * @author nalleon
 */
public interface IServices <T> {
    public boolean addToCollection(T t);
    public boolean updateCollection(T t);
    public List<T> getAllFromCollection();
    public T getByIdFromCollection(int id);
    public boolean deleteFromCollection(int id);
}