package es.ies.puerto.model.entities.impl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
/**
 * @author mackstm
 * @author nalleon
 */
@Document("PersonaUser")
public class PersonaUser {
    /**
     * Properties
     */
    @Id
    private int id;
    private String name;
    private String lastName;
    private String game;
    private String arcana;
    private boolean wildCard;

    /**
     * Default constructor of the class
     */
    public PersonaUser() {}

    /**
     * Constructor of the class
     * @param id of the PersonaUser
     */

    public PersonaUser(int id) {
        this.id = id;
    }

    /**
     * Constructor of the class
     * @param id of the PersonaUser
     * @param name of the PersonaUser
     * @param lastName of the PersonaUser
     * @param game of the PersonaUser
     * @param arcana of the PersonaUser
     * @param wildCard of the PersonaUser
     */
    public PersonaUser(int id, String name, String lastName, String game, String arcana, boolean wildCard) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.game = game;
        this.arcana = arcana;
        this.wildCard = wildCard;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getArcana() {
        return arcana;
    }

    public void setArcana(String arcana) {
        this.arcana = arcana;
    }

    public boolean isWildCard() {
        return wildCard;
    }

    public void setWildCard(boolean wildCard) {
        this.wildCard = wildCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaUser that = (PersonaUser) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PersonaUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", game='" + game + '\'' +
                ", arcana='" + arcana + '\'' +
                ", wildCard=" + wildCard +
                '}';
    }
}
