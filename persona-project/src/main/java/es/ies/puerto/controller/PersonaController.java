package es.ies.puerto.controller;

import es.ies.puerto.business.dto.PersonaDTO;
import es.ies.puerto.controller.interfaces.IController;
import es.ies.puerto.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController implements IController<PersonaDTO> {
    private PersonaService personaService;

    public PersonaController() {
    }

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @Override
    @PostMapping
    public ResponseEntity add(@RequestBody PersonaDTO personaDTO) {
        personaService.addToCollection(personaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Override
    @PutMapping
    public ResponseEntity update(@RequestBody PersonaDTO personaDTO) {
        personaService.updateCollection(personaDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(personaService.getAllFromCollection());
    }

    @Override
    public ResponseEntity getById() {
        return null;
    }

    @Override
    public ResponseEntity delete() {
        return null;
    }
}
