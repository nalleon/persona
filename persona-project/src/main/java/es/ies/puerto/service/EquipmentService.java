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
    public boolean addToCollection(EquipmentDTO equipmentDTO) {
        if (iEquipmentDao.existsById(equipmentDTO.getId())){
            return false;
        }

        iEquipmentDao.insert(IMapperEquipment.INSTANCE.equipmentDTOToEquipment(equipmentDTO));
        return true;
    }

    @Override
    public boolean updateCollection(EquipmentDTO equipmentDTO) {
        if (!iEquipmentDao.existsById(equipmentDTO.getId())){
            return false;
        }
        iEquipmentDao.save(IMapperEquipment.INSTANCE.equipmentDTOToEquipment(equipmentDTO));
        return true;
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
        if (!iEquipmentDao.existsById(id)) {
            return null;
        }

        EquipmentDTO result = null;
        List<EquipmentDTO> list = getAllFromCollection();

        for (EquipmentDTO equipment: list){
            if (equipment.getId() == id){
                result = new EquipmentDTO();
                result = equipment;
            }
        }
        return result;
    }

    @Override
    public boolean deleteFromCollection(int id) {
        if (!iEquipmentDao.existsById(id)){
            return false;
        }
        iEquipmentDao.deleteById(id);
        return true;
    }
}
