package es.ies.puerto.model.entities.impl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Set;
/**
 * @author mackstm
 * @author nalleon
 */
@Document("Compendium")
public class Persona {
    /**
     * Properties
     */

    @Id
    private int id;
    private String name;
    private String arcana;
    private Set<String> strengths;
    private Set<String> weaknesses;

    /**
     * Default constructor of the class
     */
    public Persona() {
    }

    /**
     * Constructor of the class
     * @param id of the Persona
     */

    public Persona(int id) {
        this.id = id;
    }

    /**
     * Constructor of the class
     * @param id of the Persona
     * @param name of the Persona
     * @param arcana of the Persona
     * @param strengths of the Persona
     * @param weaknesses of the Persona
     */

    public Persona(int id, String name, String arcana, Set<String> strengths, Set<String> weaknesses) {
        this.id = id;
        this.name = name;
        this.arcana = arcana;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    /**
     * Getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArcana() {
        return arcana;
    }

    public void setArcana(String arcana) {
        this.arcana = arcana;
    }

    public Set<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(Set<String> strengths) {
        this.strengths = strengths;
    }

    public Set<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(Set<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", arcana='" + arcana + '\'' +
                ", strengths=" + strengths +
                ", weaknesses=" + weaknesses +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Persona persona = (Persona) object;
        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
