package es.ies.puerto.model.db.mongo.dao;

import es.ies.puerto.model.entities.impl.PersonaUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @author mackstm
 * @author nalleon
 */
@Repository
public interface IPersonaUserDao extends MongoRepository<PersonaUser, Integer> {

}
