package es.ies.puerto.service;

import es.ies.puerto.business.dto.PersonaUserDTO;
import es.ies.puerto.mapper.struct.IMapperPersonaUser;
import es.ies.puerto.model.db.mongo.dao.IPersonaUserDao;
import es.ies.puerto.model.entities.impl.PersonaUser;
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
public class PersonaUserService implements IServices<PersonaUserDTO> {

    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonaUserService.class);

    private IPersonaUserDao iPersonaUserDao;

    /**
     * Setter of the dao
     * @param iPersonaUserDao
     */
    @Autowired
    public void setPersonaUserDao(IPersonaUserDao iPersonaUserDao) {
        this.iPersonaUserDao = iPersonaUserDao;
    }

    @Override
    public void addToCollection(PersonaUserDTO personaUserDTO) {
        iPersonaUserDao.insert(IMapperPersonaUser.INSTANCE.personaUserDTOToPersonaUser(personaUserDTO));
    }

    @Override
    public void updateCollection(PersonaUserDTO personaUserDTO) {
        PersonaUser personaUser = iPersonaUserDao.findById(personaUserDTO.getId()).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));

        personaUser = IMapperPersonaUser.INSTANCE.personaUserDTOToPersonaUser(personaUserDTO);

        iPersonaUserDao.save(personaUser);
    }

    @Override
    public List<PersonaUserDTO> getAllFromCollection() {
        List<PersonaUser> personaUsers = iPersonaUserDao.findAll();
        List<PersonaUserDTO> personaUserDTOList = new ArrayList<>();
        for (PersonaUser personaUser : personaUsers) {
            personaUserDTOList.add(IMapperPersonaUser.INSTANCE.personaUserToPersonaUserDTO(personaUser));
        }
        return personaUserDTOList;
    }

    @Override
    public PersonaUserDTO getByIdFromCollection(int id) {
        PersonaUser personaUser = iPersonaUserDao.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        return IMapperPersonaUser.INSTANCE.personaUserToPersonaUserDTO(personaUser);
    }

    @Override
    public void deleteFromCollection(int id) {
        PersonaUser personaUser = iPersonaUserDao.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        iPersonaUserDao.delete(personaUser);
    }
}
