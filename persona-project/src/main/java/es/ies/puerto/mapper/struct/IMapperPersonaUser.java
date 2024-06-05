package es.ies.puerto.mapper.struct;

import es.ies.puerto.business.dto.PersonaUserDTO;
import es.ies.puerto.model.entities.impl.PersonaUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMapperPersonaUser {
    IMapperPersonaUser INSTANCE = Mappers.getMapper(IMapperPersonaUser.class);

    PersonaUser personaUserDTOToPersonaUser(PersonaUserDTO personaUserDTO);
    PersonaUserDTO personaUserToPersonaUserDTO(PersonaUser personaUser);
}
