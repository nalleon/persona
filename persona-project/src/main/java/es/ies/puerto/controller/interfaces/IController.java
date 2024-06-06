package es.ies.puerto.controller.interfaces;

import es.ies.puerto.business.dto.PersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
/**
 * @author mackstm
 * @author nalleon
 */
public interface IController <T> {
    public ResponseEntity add(T t);
    public ResponseEntity update(T t);

    public ResponseEntity<List<T>> getAll();
    public ResponseEntity<T> getById(int id);
    public ResponseEntity delete(int id);
}
