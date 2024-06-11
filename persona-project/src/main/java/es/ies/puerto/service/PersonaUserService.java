package es.ies.puerto.service;

import es.ies.puerto.business.dto.EquipmentDTO;
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
    public boolean addToCollection(PersonaUserDTO personaUserDTO) {
        if (iPersonaUserDao.existsById(personaUserDTO.getId())){
            return false;
        }

        iPersonaUserDao.insert(IMapperPersonaUser.INSTANCE.personaUserDTOToPersonaUser(personaUserDTO));
        return true;
    }

    @Override
    public boolean updateCollection(PersonaUserDTO personaUserDTO) {
        if (!iPersonaUserDao.existsById(personaUserDTO.getId())){
           return false;
        }

        iPersonaUserDao.save(IMapperPersonaUser.INSTANCE.personaUserDTOToPersonaUser(personaUserDTO));
        return true;

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
        if (!iPersonaUserDao.existsById(id)){
            return null;
        }

        PersonaUserDTO result = null;
        List<PersonaUserDTO> personaUserDTOS = getAllFromCollection();

        for (PersonaUserDTO personaUserDTO : personaUserDTOS){
            if (personaUserDTO.getId() == id){
                result = personaUserDTO;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean deleteFromCollection(int id) {
        if (!iPersonaUserDao.existsById(id)){
            return false;
        }
        iPersonaUserDao.deleteById(id);
        return true;
    }
}
