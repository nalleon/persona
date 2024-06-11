package es.ies.puerto.services;

import es.ies.puerto.business.dto.EquipmentDTO;
import es.ies.puerto.model.db.mongo.dao.IEquipmentDao;
import es.ies.puerto.model.entities.impl.Equipment;
import es.ies.puerto.service.EquipmentService;
import es.ies.puerto.service.interfaces.IServices;
import es.ies.puerto.utilities.UtilitiesTest;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EquipmentServiceTest extends UtilitiesTest {

    @Mock
    IEquipmentDao daoMock;

    @InjectMocks
    EquipmentService service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new EquipmentService();
        service.setEquipmentDao(daoMock);
    }
    @Test
    void getAllTest() {
        List<Equipment> list = new ArrayList<>();
        list.add(new Equipment(1));
        list.add(new Equipment(2));
        list.add(new Equipment(3));
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getAllFromCollection(), MESSAGE_ERROR);
    }

    //@Test
    void getOneTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        Assertions.assertNotNull(service.getByIdFromCollection(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(daoMock.save(any(Equipment.class))).thenReturn(new Equipment());
        Assertions.assertTrue(service.addToCollection(new EquipmentDTO(1)), MESSAGE_ERROR);
    }

  //  @Test
    void addDupeTest() {
        when(daoMock.save(any(Equipment.class))).thenReturn(null);
        Assertions.assertFalse(service.addToCollection(new EquipmentDTO(10000)), MESSAGE_ERROR);
    }

    @Test
    void deleteTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        Assertions.assertTrue(service.deleteFromCollection(1), MESSAGE_ERROR);
    }

    @Test
    void deleteNonExistentTest() {
        when(daoMock.existsById(1)).thenReturn(false);
        Assertions.assertFalse(service.deleteFromCollection(1), MESSAGE_ERROR);
    }

    @Test
    void updateTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        when(daoMock.save(new Equipment(1))).thenReturn(new Equipment(1));

        Assertions.assertTrue(service.updateCollection(new EquipmentDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void updateNonexistentTest() {
        when(daoMock.existsById(1)).thenReturn(false);
        Assertions.assertFalse(service.updateCollection(new EquipmentDTO(1)), MESSAGE_ERROR);
    }

}
