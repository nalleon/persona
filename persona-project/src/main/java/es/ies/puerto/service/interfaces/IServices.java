package es.ies.puerto.service.interfaces;

import es.ies.puerto.business.dto.PersonaDTO;

import java.util.List;

public interface IServices <T> {
    public void addToCollection(T t);
    public void updateCollection(T t);
    public List<T> getAllFromCollection();
    public void getByIdFromCollection();
    public void deleteFromCollection();
}
