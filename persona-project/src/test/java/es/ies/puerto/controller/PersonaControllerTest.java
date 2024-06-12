package es.ies.puerto.controller;

import es.ies.puerto.business.dto.PersonaDTO;
import es.ies.puerto.service.PersonaService;
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

public class PersonaControllerTest extends UtilitiesTest {
    @Mock
    PersonaService serviceMock;

    @InjectMocks
    PersonaController controller;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        controller = new PersonaController();
        controller.setPersonaService(serviceMock);
    }

    @Test
    void addTest() {
        when(serviceMock.addToCollection(new PersonaDTO())).thenReturn(true);
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(),
                controller.add(new PersonaDTO()), MESSAGE_ERROR);
    }

    @Test
    void updateTest() {
        when(serviceMock.updateCollection(new PersonaDTO())).thenReturn(true);
        Assertions.assertEquals(ResponseEntity.ok().build(), controller.update(new PersonaDTO()), MESSAGE_ERROR);
    }

    @Test
    void getAllTest() {
        when(serviceMock.getAllFromCollection()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(ResponseEntity.ok(new ArrayList()), controller.getAll(), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(serviceMock.getByIdFromCollection(1)).thenReturn(new PersonaDTO());
        Assertions.assertEquals(ResponseEntity.ok(new PersonaDTO()), controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void deleteTest() {
        when(serviceMock.deleteFromCollection(1)).thenReturn(true);
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(),
                controller.delete(1), MESSAGE_ERROR);
    }
}
