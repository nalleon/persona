package es.ies.puerto.controller;

import es.ies.puerto.business.dto.PersonaUserDTO;
import es.ies.puerto.controller.interfaces.IController;
import es.ies.puerto.service.PersonaUserService;
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
@RequestMapping("/personaUser")
public class PersonaUserController implements IController<PersonaUserDTO> {

    /**
     * Properties
     */
    private PersonaUserService personaUserService;

    /**
     * Default constructor of the class
     */
    public PersonaUserController() {
    }

    /**
     * Constructor of the class
     * @param personaUserService of the PersonaUserController
     */

    public PersonaUserController(PersonaUserService personaUserService) {
        this.personaUserService = personaUserService;
    }

    /**
     * Setter of the service
     * @param personaUserService of the PersonaUserController
     */
    @Autowired
    public void setPersonaUserService(PersonaUserService personaUserService) {
        this.personaUserService = personaUserService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity add(@RequestBody PersonaUserDTO personaUserDTO) {
        personaUserService.addToCollection(personaUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Override
    @PutMapping("/")
    public ResponseEntity update(@RequestBody PersonaUserDTO personaUserDTO) {
        personaUserService.updateCollection(personaUserDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<PersonaUserDTO>> getAll() {
        return ResponseEntity.ok(personaUserService.getAllFromCollection());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PersonaUserDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(personaUserService.getByIdFromCollection(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        personaUserService.deleteFromCollection(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
