package es.ies.puerto.controller;

import es.ies.puerto.business.dto.PersonaDTO;
import es.ies.puerto.controller.interfaces.IController;
import es.ies.puerto.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author mackstm
 * @author nalleon
 */
@RestController
@RequestMapping("/persona")
public class PersonaController implements IController<PersonaDTO> {

    /**
     * Properties
     */
    private PersonaService personaService;

    /**
     * Deafult constructor of the class
     */
    public PersonaController() {
    }

    /**
     * Constructor of the class
     * @param personaService of the PersonaController
     */
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    /**
     * Setter of the service
     * @param personaService of the PersonaController
     */
    @Autowired
    public void setPersonaService(PersonaService personaService) {
        this.personaService = personaService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity add(@RequestBody PersonaDTO personaDTO) {
        personaService.addToCollection(personaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Override
    @PutMapping("/")
    public ResponseEntity update(@RequestBody PersonaDTO personaDTO) {
        personaService.updateCollection(personaDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<PersonaDTO>> getAll() {
        return ResponseEntity.ok(personaService.getAllFromCollection());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(personaService.getByIdFromCollection(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        personaService.deleteFromCollection(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
