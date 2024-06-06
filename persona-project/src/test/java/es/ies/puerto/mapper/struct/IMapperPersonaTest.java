package es.ies.puerto.mapper.struct;

import es.ies.puerto.business.dto.PersonaDTO;
import es.ies.puerto.model.entities.impl.Persona;
import es.ies.puerto.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IMapperPersonaTest extends MapperHelper {
    Persona personaEntityMapper;
    PersonaDTO personaDTOMapper;

    @Test
    public void toDTOTest(){
        personaDTOMapper = IMapperPersona.INSTANCE.personaToPersonaDTO(personaEntity);

        Assertions.assertEquals(personaDTO.getId(), personaDTOMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(personaDTO.getName(), personaDTOMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(personaDTO.getArcana(), personaDTOMapper.getArcana(), MESSAGE_ERROR);
        Assertions.assertEquals(personaDTO.getStrengths(), personaDTOMapper.getStrengths(), MESSAGE_ERROR);
        Assertions.assertEquals(personaDTO.getWeaknesses(), personaDTOMapper.getWeaknesses(), MESSAGE_ERROR);


        personaEntity = null;
        personaDTOMapper = IMapperPersona.INSTANCE.personaToPersonaDTO(personaEntity);
        Assertions.assertNull(personaDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        personaEntityMapper = IMapperPersona.INSTANCE.personaDTOToPersona(personaDTO);

        Assertions.assertEquals(personaEntity.getId(), personaEntityMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(personaEntity.getName(), personaEntityMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(personaEntity.getArcana(), personaEntityMapper.getArcana(), MESSAGE_ERROR);
        Assertions.assertEquals(personaEntity.getStrengths(), personaEntityMapper.getStrengths(), MESSAGE_ERROR);
        Assertions.assertEquals(personaEntity.getWeaknesses(), personaEntityMapper.getWeaknesses(), MESSAGE_ERROR);
        personaDTO = null;
        personaEntityMapper = IMapperPersona.INSTANCE.personaDTOToPersona(personaDTO);
        Assertions.assertNull(personaEntityMapper, MESSAGE_ERROR);
    }
}
