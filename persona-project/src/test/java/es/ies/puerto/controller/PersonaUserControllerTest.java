package es.ies.puerto.controller;

import es.ies.puerto.business.dto.PersonaUserDTO;
import es.ies.puerto.service.PersonaUserService;
import es.ies.puerto.utilities.UtilitiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class PersonaUserControllerTest extends UtilitiesTest {
    @Mock
    PersonaUserService serviceMock;

    @InjectMocks
    PersonaUserController controller;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        controller = new PersonaUserController();
        controller.setPersonaUserService(serviceMock);
    }

    @Test
    void addTest() {
        when(serviceMock.addToCollection(new PersonaUserDTO())).thenReturn(true);
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(),
                controller.add(new PersonaUserDTO()), MESSAGE_ERROR);
    }

    @Test
    void updateTest() {
        when(serviceMock.updateCollection(new PersonaUserDTO())).thenReturn(true);
        Assertions.assertEquals(ResponseEntity.ok().build(), controller.update(new PersonaUserDTO()), MESSAGE_ERROR);
    }

    @Test
    void getAllTest() {
        when(serviceMock.getAllFromCollection()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(ResponseEntity.ok(new ArrayList()), controller.getAll(), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(serviceMock.getByIdFromCollection(1)).thenReturn(new PersonaUserDTO());
        Assertions.assertEquals(ResponseEntity.ok(new PersonaUserDTO()), controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void deleteTest() {
        when(serviceMock.deleteFromCollection(1)).thenReturn(true);
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(),
                controller.delete(1), MESSAGE_ERROR);
    }
}
