package es.ies.puerto.controller;

import es.ies.puerto.business.dto.EquipmentDTO;
import es.ies.puerto.controller.interfaces.IController;
import es.ies.puerto.service.EquipmentService;
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
@RequestMapping("/equipment")
public class EquipmentController implements IController<EquipmentDTO> {

    /**
     * Properties
     */
    private EquipmentService equipmentService;

    /**
     * Default constructor of the class
     */
    public EquipmentController() {
    }

    /**
     * Constructor of the class
     * @param equipmentService of the EquipmentController
     */

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    /**
     * Setter of the service
     * @param equipmentService of the EquipmentController
     */
    @Autowired
    public void setEquipmentService(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity add(@RequestBody EquipmentDTO equipmentDTO) {
        equipmentService.addToCollection(equipmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Override
    @PutMapping("/")
    public ResponseEntity update(@RequestBody EquipmentDTO equipmentDTO) {
        equipmentService.updateCollection(equipmentDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<EquipmentDTO>> getAll() {
        return ResponseEntity.ok(equipmentService.getAllFromCollection());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EquipmentDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(equipmentService.getByIdFromCollection(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        equipmentService.deleteFromCollection(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
