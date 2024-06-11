package es.ies.puerto.business.dto;

import es.ies.puerto.model.entities.impl.PersonaUser;
import es.ies.puerto.utilities.UtilitiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaUserDTOTest extends UtilitiesTest {
    public static final int ID = 1;
    public static final String NAME = "nameTest";
    public static final String ARCANA = "arcanaTest";
    public static final String LAST_NAME = "lastNameTest";
    public static final boolean WILD_CARD = true;
    public static final String GAME = "gameTest";
    PersonaUserDTO personaUser;
    @BeforeEach
    public void beforeEach(){
        personaUser = new PersonaUserDTO();
        personaUser.setId(ID);
        personaUser.setName(NAME);
        personaUser.setLastName(LAST_NAME);
        personaUser.setArcana(ARCANA);
        personaUser.setGame(GAME);
        personaUser.setWildCard(WILD_CARD);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(ID, personaUser.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(NAME, personaUser.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(ARCANA, personaUser.getArcana(), MESSAGE_ERROR);
        Assertions.assertEquals(LAST_NAME, personaUser.getLastName(), MESSAGE_ERROR);
        Assertions.assertEquals(GAME, personaUser.getGame(), MESSAGE_ERROR);
        Assertions.assertEquals(WILD_CARD, personaUser.isWildCard(), MESSAGE_ERROR);

    }

    @Test
    public void equalsTest(){
        PersonaUserDTO equalsObject = new PersonaUserDTO(ID);
        PersonaUserDTO notEquals = new PersonaUserDTO(34, NAME, LAST_NAME, ARCANA, GAME, WILD_CARD);
        String str = "strTest";
        PersonaUserDTO nullObject = null;

        Assertions.assertEquals(equalsObject.hashCode(), personaUser.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(equalsObject, personaUser, MESSAGE_ERROR);
        Assertions.assertTrue(personaUser.equals(equalsObject));
        Assertions.assertTrue(personaUser.equals(personaUser), MESSAGE_ERROR);
        Assertions.assertFalse(personaUser.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(personaUser.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(personaUser.equals(str), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(personaUser.toString().contains(String.valueOf(ID)), MESSAGE_ERROR);
        Assertions.assertTrue(personaUser.toString().contains(NAME), MESSAGE_ERROR);
        Assertions.assertTrue(personaUser.toString().contains(ARCANA), MESSAGE_ERROR);
        Assertions.assertTrue(personaUser.toString().contains(LAST_NAME), MESSAGE_ERROR);
        Assertions.assertTrue(personaUser.toString().contains(GAME), MESSAGE_ERROR);
        Assertions.assertTrue(personaUser.toString().contains(String.valueOf(WILD_CARD)), MESSAGE_ERROR);
    }
}
