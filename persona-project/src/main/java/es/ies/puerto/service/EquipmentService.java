package es.ies.puerto.service;

import es.ies.puerto.business.dto.EquipmentDTO;
import es.ies.puerto.mapper.struct.IMapperEquipment;
import es.ies.puerto.model.db.mongo.dao.IEquipmentDao;
import es.ies.puerto.model.entities.impl.Equipment;
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
public class EquipmentService implements IServices<EquipmentDTO> {

    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(EquipmentService.class);

    private IEquipmentDao iEquipmentDao;

    /**
     * Setter of the dao
     * @param iEquipmentDao
     */
    @Autowired
    public void setEquipmentDao(IEquipmentDao iEquipmentDao) {
        this.iEquipmentDao = iEquipmentDao;
    }

    @Override
    public void addToCollection(EquipmentDTO equipmentDTO) {
        iEquipmentDao.insert(IMapperEquipment.INSTANCE.equipmentDTOToEquipment(equipmentDTO));
    }

    @Override
    public void updateCollection(EquipmentDTO equipmentDTO) {
        Equipment equipment = iEquipmentDao.findById(equipmentDTO.getId()).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));

        equipment = IMapperEquipment.INSTANCE.equipmentDTOToEquipment(equipmentDTO);

        iEquipmentDao.save(equipment);
    }

    @Override
    public List<EquipmentDTO> getAllFromCollection() {
        List<Equipment> equipments = iEquipmentDao.findAll();
        List<EquipmentDTO> equipmentDTOList = new ArrayList<>();
        for (Equipment equipment : equipments) {
            equipmentDTOList.add(IMapperEquipment.INSTANCE.equipmentToEquipmentDTO(equipment));
        }
        return equipmentDTOList;
    }

    @Override
    public EquipmentDTO getByIdFromCollection(int id) {
        Equipment equipment = iEquipmentDao.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        return IMapperEquipment.INSTANCE.equipmentToEquipmentDTO(equipment);
    }

    @Override
    public void deleteFromCollection(int id) {
        Equipment equipment = iEquipmentDao.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        iEquipmentDao.delete(equipment);
    }
}
