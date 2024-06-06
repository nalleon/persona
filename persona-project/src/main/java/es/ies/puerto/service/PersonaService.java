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


@Service
public class PersonaService implements IServices<PersonaDTO> {
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonaService.class);

    private IPersonaDao iPersonaDao;

    @Autowired
    public void setPersonaDao(IPersonaDao iPersonaDao) {
        this.iPersonaDao = iPersonaDao;
    }

    @Override
    public void addToCollection(PersonaDTO personaDTO) {
        iPersonaDao.insert(IMapperPersona.INSTANCE.personaDTOToPersona(personaDTO));
    }

    @Override
    public void updateCollection(PersonaDTO personaDTO) {
        Persona persona = iPersonaDao.findById(personaDTO.getId()).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));

        persona = IMapperPersona.INSTANCE.personaDTOToPersona(personaDTO);

        iPersonaDao.save(persona);
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
    public void deleteFromCollection(int id) {
        Persona persona = iPersonaDao.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        iPersonaDao.delete(persona);
    }
}
