package es.ies.puerto.mapper.struct;

import es.ies.puerto.business.dto.EquipmentDTO;
import es.ies.puerto.model.entities.impl.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMapperEquipment {
    IMapperEquipment INSTANCE = Mappers.getMapper(IMapperEquipment.class);

    Equipment equipmentDTOToEquipment(EquipmentDTO equipmentDTO);
    EquipmentDTO equipmentToEquipmentDTO(Equipment equipment);
}
