package es.ies.puerto.service;

import es.ies.puerto.business.dto.PersonaDTO;
import es.ies.puerto.mapper.struct.IMapperPersona;
import es.ies.puerto.model.db.mongo.dao.IPersonaDao;
import es.ies.puerto.model.entities.impl.Persona;
import es.ies.puerto.service.interfaces.IServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mackstm
 * @author nalleon
 */
@Service
public class PersonaService implements IServices<PersonaDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonaService.class);

    private IPersonaDao iPersonaDao;

    /**
     * Setter of the dao
     * @param iPersonaDao
     */
    @Autowired
    public void setPersonaDao(IPersonaDao iPersonaDao) {
        this.iPersonaDao = iPersonaDao;
    }

    @Override
    public boolean addToCollection(PersonaDTO personaDTO) {
        if (iPersonaDao.existsById(personaDTO.getId())){
            return false;
        }
        iPersonaDao.insert(IMapperPersona.INSTANCE.personaDTOToPersona(personaDTO));
        return true;
    }

    @Override
    public boolean updateCollection(PersonaDTO personaDTO) {
        if (!iPersonaDao.existsById(personaDTO.getId())){
            return false;
        }

        iPersonaDao.save(IMapperPersona.INSTANCE.personaDTOToPersona(personaDTO));
        return true;
    }

    @Override
    public List<PersonaDTO> getAllFromCollection() {
        List<Persona> personas = iPersonaDao.findAll();
        List<PersonaDTO> personaDTOList = new ArrayList<>();
        for (Persona persona : personas) {
            personaDTOList.add(IMapperPersona.INSTANCE.personaToPersonaDTO(persona));
        }
        return personaDTOList;
    }

    @Override
    public PersonaDTO getByIdFromCollection(int id) {
        Persona persona = iPersonaDao.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        return IMapperPersona.INSTANCE.personaToPersonaDTO(persona);
    }

    @Override
    public boolean deleteFromCollection(int id) {
        if (!iPersonaDao.existsById(id)){
            return false;
        }
        iPersonaDao.deleteById(id);
        return true;
    }
}
