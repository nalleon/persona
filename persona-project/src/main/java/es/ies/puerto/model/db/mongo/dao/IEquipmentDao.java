package es.ies.puerto.model.db.mongo.dao;

import es.ies.puerto.model.entities.impl.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEquipmentDao extends MongoRepository<Equipment, Integer> {

}
