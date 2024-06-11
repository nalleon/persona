package es.ies.puerto.model.entities;

import es.ies.puerto.model.entities.impl.Equipment;
import es.ies.puerto.model.entities.impl.Persona;
import es.ies.puerto.utilities.UtilitiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class PersonaTest extends UtilitiesTest {
    public static final int ID = 1;
    public static final String NAME = "nameTest";
    public static final String ARCANA = "arcanaTest";
    public static final HashSet<String> WEAKNESSES = new HashSet<>(Arrays.asList("wkn1", "wkn2"));
    public static final HashSet<String> STRENGTHS = new HashSet<>(Arrays.asList("str1", "str2"));
    Persona persona;
    @BeforeEach
    public void beforeEach(){
        persona = new Persona();
        persona.setId(ID);
        persona.setName(NAME);
        persona.setArcana(ARCANA);
        persona.setStrengths(STRENGTHS);
        persona.setWeaknesses(WEAKNESSES);
    }

    @Test
    public void getSetTest(){

        Assertions.assertEquals(ID, persona.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(NAME, persona.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(ARCANA, persona.getArcana(), MESSAGE_ERROR);
        Assertions.assertEquals(STRENGTHS, persona.getStrengths(), MESSAGE_ERROR);
        Assertions.assertEquals(WEAKNESSES, persona.getWeaknesses(), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        Persona equalsObject = new Persona(ID);
        Persona notEquals = new Persona(34, NAME, ARCANA, STRENGTHS, WEAKNESSES);
        String str = "strTest";
        Persona nullObject = null;

        Assertions.assertEquals(equalsObject.hashCode(), persona.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(equalsObject, persona, MESSAGE_ERROR);
        Assertions.assertTrue(persona.equals(equalsObject), MESSAGE_ERROR);

        Assertions.assertTrue(persona.equals(persona), MESSAGE_ERROR);
        Assertions.assertFalse(persona.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(persona.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(persona.equals(str), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(persona.toString().contains(String.valueOf(ID)), MESSAGE_ERROR);
        Assertions.assertTrue(persona.toString().contains(NAME), MESSAGE_ERROR);
        Assertions.assertTrue(persona.toString().contains(ARCANA), MESSAGE_ERROR);
        Assertions.assertTrue(persona.toString().contains(STRENGTHS.toString()), MESSAGE_ERROR);
        Assertions.assertTrue(persona.toString().contains(WEAKNESSES.toString()), MESSAGE_ERROR);
    }
}
