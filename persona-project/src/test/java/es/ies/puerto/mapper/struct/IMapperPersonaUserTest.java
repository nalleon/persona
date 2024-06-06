package es.ies.puerto.mapper.struct;

import es.ies.puerto.business.dto.PersonaUserDTO;
import es.ies.puerto.model.entities.impl.PersonaUser;
import es.ies.puerto.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IMapperPersonaUserTest extends MapperHelper {
    PersonaUser personaUserEntityMapper;
    PersonaUserDTO personaUserDTOMapper;

    @Test
    public void toDTOTest(){
        personaUserDTOMapper = IMapperPersonaUser.INSTANCE.personaUserToPersonaUserDTO(personaUserEntity);

        Assertions.assertEquals(personaUserDTO.getId(), personaUserDTOMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserDTO.getName(), personaUserDTOMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserDTO.getArcana(), personaUserDTOMapper.getArcana(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserDTO.getGame(), personaUserDTOMapper.getGame(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserDTO.getLastName(), personaUserDTOMapper.getLastName(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserDTO.isWildCard(), personaUserDTOMapper.isWildCard(), MESSAGE_ERROR);


        personaUserEntity = null;
        personaUserDTOMapper = IMapperPersonaUser.INSTANCE.personaUserToPersonaUserDTO(personaUserEntity);
        Assertions.assertNull(personaUserDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        personaUserEntityMapper = IMapperPersonaUser.INSTANCE.personaUserDTOToPersonaUser(personaUserDTO);

        Assertions.assertEquals(personaUserEntity.getId(), personaUserEntityMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserEntity.getName(), personaUserEntityMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserEntity.getArcana(), personaUserEntityMapper.getArcana(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserEntity.getGame(), personaUserEntityMapper.getGame(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserEntity.getLastName(), personaUserEntityMapper.getLastName(), MESSAGE_ERROR);
        Assertions.assertEquals(personaUserEntity.isWildCard(), personaUserEntityMapper.isWildCard(), MESSAGE_ERROR);


        personaUserDTO = null;
        personaUserEntityMapper = IMapperPersonaUser.INSTANCE.personaUserDTOToPersonaUser(personaUserDTO);
        Assertions.assertNull(personaUserEntityMapper, MESSAGE_ERROR);
    }
}
