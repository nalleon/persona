package es.ies.puerto.model.entities.impl;

import java.util.Objects;
import java.util.Set;

public class Persona {
    int _id;
    String name;
    String arcana;
    Set<String> strengths;
    Set<String> weaknesses;

    public Persona() {
    }

    public Persona(int _id) {
        this._id = _id;
    }

    public Persona(int _id, String name, String arcana, Set<String> strengths, Set<String> weaknesses) {
        this._id = _id;
        this.name = name;
        this.arcana = arcana;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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
                "_id=" + _id +
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
        return _id == persona._id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }
}
