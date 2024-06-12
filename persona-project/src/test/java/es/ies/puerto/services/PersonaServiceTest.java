package es.ies.puerto.services;

import es.ies.puerto.business.dto.EquipmentDTO;
import es.ies.puerto.business.dto.PersonaDTO;
import es.ies.puerto.model.db.mongo.dao.IEquipmentDao;
import es.ies.puerto.model.db.mongo.dao.IPersonaDao;
import es.ies.puerto.model.entities.impl.Equipment;
import es.ies.puerto.model.entities.impl.Persona;
import es.ies.puerto.service.EquipmentService;
import es.ies.puerto.service.PersonaService;
import es.ies.puerto.utilities.UtilitiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PersonaServiceTest extends UtilitiesTest {

    @Mock
    IPersonaDao daoMock;

    @InjectMocks
    PersonaService service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new PersonaService();
        service.setPersonaDao(daoMock);
    }
    @Test
    void getAllTest() {
        List<Persona> list = new ArrayList<>();
        list.add(new Persona(1));
        list.add(new Persona(2));
        list.add(new Persona(3));
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getAllFromCollection(), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.findById(1)).thenReturn(Optional.of(new Persona()));
        Assertions.assertNotNull(service.getByIdFromCollection(1), MESSAGE_ERROR);
    }

    @Test
    void getOneNonexistent() {
        RuntimeException thrown;
        thrown = assertThrows(RuntimeException.class, () -> {
            service.getByIdFromCollection(1);
        });
        Assertions.assertEquals("Cannot find by ID", thrown.getMessage(), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(daoMock.save(any(Persona.class))).thenReturn(new Persona());
        Assertions.assertTrue(service.addToCollection(new PersonaDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void addDupeTest() {
        when(daoMock.existsById(10000)).thenReturn(true);
        Assertions.assertFalse(service.addToCollection(new PersonaDTO(10000)), MESSAGE_ERROR);
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
        when(daoMock.save(new Persona(1))).thenReturn(new Persona(1));

        Assertions.assertTrue(service.updateCollection(new PersonaDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void updateNonexistentTest() {
        when(daoMock.existsById(1)).thenReturn(false);
        Assertions.assertFalse(service.updateCollection(new PersonaDTO(1)), MESSAGE_ERROR);
    }


}
