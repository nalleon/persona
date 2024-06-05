package es.ies.puerto.business.dto;

import java.util.Objects;

public class PersonaUserDTO {
    private int id;
    private String name;
    private String lastName;
    private String game;
    private String arcana;
    private boolean wildCard;

    public PersonaUserDTO() {}

    public PersonaUserDTO(int id) {
        this.id = id;
    }

    public PersonaUserDTO(int id, String name, String lastName, String game, String arcana, boolean wildCard) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.game = game;
        this.arcana = arcana;
        this.wildCard = wildCard;
    }

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
        PersonaUserDTO personaUserDTO = (PersonaUserDTO) o;
        return id == personaUserDTO.id;
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
