package es.ies.puerto.model.db.mongo.dao;

import es.ies.puerto.model.entities.impl.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPersonaDao extends MongoRepository<Persona, Integer> {

}
