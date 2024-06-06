package es.ies.puerto.business.dto;

import java.util.Objects;
import java.util.Set;
/**
 * @author mackstm
 * @author nalleon
 */
public class PersonaDTO {
    /**
     * Properties
     */
    private int id;
    private String name;
    private String arcana;
    private Set<String> strengths;
    private Set<String> weaknesses;

    /**
     * Default constructor of the class
     */
    public PersonaDTO() {
    }

    /**
     * Constructor of the class
     * @param id of the PersonaDTO
     */
    public PersonaDTO(int id) {
        this.id = id;
    }

    /**
     * Constructor of the class
     * @param id of the PersonaDTO
     * @param name of the PersonaDTO
     * @param arcana of the PersonaDTO
     * @param strengths of the PersonaDTO
     * @param weaknesses of the PersonaDTO
     */
    public PersonaDTO(int id, String name, String arcana, Set<String> strengths, Set<String> weaknesses) {
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
        PersonaDTO personaDTO = (PersonaDTO) object;
        return id == personaDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
