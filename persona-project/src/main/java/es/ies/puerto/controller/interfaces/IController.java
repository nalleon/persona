package es.ies.puerto.controller.interfaces;

import es.ies.puerto.business.dto.PersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

public interface IController <T> {
    public ResponseEntity add(T t);
    public ResponseEntity update(T t);

    public ResponseEntity getAll();
    public ResponseEntity getById();
    public ResponseEntity delete();
}
