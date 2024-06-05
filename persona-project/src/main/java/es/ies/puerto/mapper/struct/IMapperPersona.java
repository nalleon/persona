package es.ies.puerto.mapper.struct;

import es.ies.puerto.business.dto.PersonaDTO;
import es.ies.puerto.model.entities.impl.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMapperPersona {
    IMapperPersona INSTANCE = Mappers.getMapper(IMapperPersona.class);

    Persona personaDTOToPersona(PersonaDTO personaDTO);
    PersonaDTO personaToPersonaDTO(Persona persona);
}
