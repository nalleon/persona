package es.ies.puerto.model.db.mongo.dao;

import es.ies.puerto.model.entities.impl.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @author mackstm
 * @author nalleon
 */
@Repository
public interface IPersonaDao extends MongoRepository<Persona, Integer> {

}
