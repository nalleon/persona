package es.ies.puerto.mapper.struct;

import es.ies.puerto.business.dto.EquipmentDTO;
import es.ies.puerto.model.entities.impl.Equipment;
import es.ies.puerto.model.entities.impl.Persona;
import es.ies.puerto.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IMapperEquipmentTest extends MapperHelper {

    Equipment equipmentEntityMapper;
    EquipmentDTO equipmentDTOMapper;

    @Test
    public void toDTOTest(){
        equipmentDTOMapper = IMapperEquipment.INSTANCE.equipmentToEquipmentDTO(equipmentEntity);

        Assertions.assertEquals(equipmentDTO.getId(), equipmentDTOMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(equipmentDTO.getWeaponName(), equipmentDTOMapper.getWeaponName(), MESSAGE_ERROR);
        Assertions.assertEquals(equipmentDTO.getShopPrice(), equipmentDTOMapper.getShopPrice(), MESSAGE_ERROR);
        Assertions.assertEquals(equipmentDTO.getWeaponType(), equipmentDTOMapper.getWeaponType(), MESSAGE_ERROR);

        equipmentEntity = null;
        equipmentDTOMapper = IMapperEquipment.INSTANCE.equipmentToEquipmentDTO(equipmentEntity);
        Assertions.assertNull(equipmentDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        equipmentEntityMapper = IMapperEquipment.INSTANCE.equipmentDTOToEquipment(equipmentDTO);

        Assertions.assertEquals(equipmentEntity.getId(), equipmentEntityMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(equipmentEntity.getWeaponName(), equipmentEntityMapper.getWeaponName(), MESSAGE_ERROR);
        Assertions.assertEquals(equipmentEntity.getShopPrice(), equipmentEntityMapper.getShopPrice(), MESSAGE_ERROR);
        Assertions.assertEquals(equipmentEntity.getWeaponType(), equipmentEntityMapper.getWeaponType(), MESSAGE_ERROR);

        equipmentDTO = null;
        equipmentEntityMapper = IMapperEquipment.INSTANCE.equipmentDTOToEquipment(equipmentDTO);
        Assertions.assertNull(equipmentDTOMapper, MESSAGE_ERROR);
    }
}
