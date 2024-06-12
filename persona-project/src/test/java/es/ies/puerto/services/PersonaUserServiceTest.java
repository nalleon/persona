package es.ies.puerto.services;

import es.ies.puerto.business.dto.PersonaUserDTO;
import es.ies.puerto.model.db.mongo.dao.IPersonaUserDao;
import es.ies.puerto.model.entities.impl.Persona;
import es.ies.puerto.model.entities.impl.PersonaUser;
import es.ies.puerto.service.PersonaUserService;
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

public class PersonaUserServiceTest extends UtilitiesTest {
    @Mock
    IPersonaUserDao daoMock;

    @InjectMocks
    PersonaUserService service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new PersonaUserService();
        service.setPersonaUserDao(daoMock);
    }
    @Test
    void getAllTest() {
        List<PersonaUser> list = new ArrayList<>();
        list.add(new PersonaUser(1));
        list.add(new PersonaUser(2));
        list.add(new PersonaUser(3));
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getAllFromCollection(), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.findById(1)).thenReturn(Optional.of(new PersonaUser()));
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
        when(daoMock.save(any(PersonaUser.class))).thenReturn(new PersonaUser());
        Assertions.assertTrue(service.addToCollection(new PersonaUserDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void addDupeTest() {
        when(daoMock.existsById(10000)).thenReturn(true);
        Assertions.assertFalse(service.addToCollection(new PersonaUserDTO(10000)), MESSAGE_ERROR);
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
        when(daoMock.save(new PersonaUser(1))).thenReturn(new PersonaUser(1));

        Assertions.assertTrue(service.updateCollection(new PersonaUserDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void updateNonexistentTest() {
        when(daoMock.existsById(1)).thenReturn(false);
        Assertions.assertFalse(service.updateCollection(new PersonaUserDTO(1)), MESSAGE_ERROR);
    }


}
