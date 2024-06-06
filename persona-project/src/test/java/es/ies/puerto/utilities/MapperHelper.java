package es.ies.puerto.utilities;

import es.ies.puerto.business.dto.EquipmentDTO;
import es.ies.puerto.business.dto.PersonaDTO;
import es.ies.puerto.business.dto.PersonaDTOTest;
import es.ies.puerto.business.dto.PersonaUserDTO;
import es.ies.puerto.model.entities.impl.Equipment;
import es.ies.puerto.model.entities.impl.Persona;
import es.ies.puerto.model.entities.impl.PersonaUser;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.HashSet;

public class MapperHelper extends UtilitiesTest {
    public static final int ID = 1;
    public static final String NAME = "nameTest";
    public static final int SHOP_PRICE = 1234;
    public static final String WEAPON_TYPE = "weaponTypeTest";
    public static final String ARCANA = "arcanaTest";
    public static final HashSet<String> WEAKNESSES = new HashSet<>(Arrays.asList("wkn1", "wkn2"));
    public static final HashSet<String> STRENGTHS = new HashSet<>(Arrays.asList("str1", "str2"));
    public static final String LAST_NAME = "lastNameTest";
    public static final boolean WILD_CARD = true;
    public static final String GAME = "gameTest";
    public Persona personaEntity;
    public PersonaDTO personaDTO;
    public Equipment equipmentEntity;
    public EquipmentDTO equipmentDTO;

    public PersonaUser personaUserEntity;
    public PersonaUserDTO personaUserDTO;

    @BeforeEach
    public void beforeEach(){
        equipmentEntity = new Equipment();
        equipmentEntity.setId(ID);
        equipmentEntity.setWeaponName(NAME);
        equipmentEntity.setShopPrice(SHOP_PRICE);
        equipmentEntity.setWeaponType(WEAPON_TYPE);

        equipmentDTO = new EquipmentDTO();
        equipmentDTO.setId(ID);
        equipmentDTO.setWeaponName(NAME);
        equipmentDTO.setShopPrice(SHOP_PRICE);
        equipmentDTO.setWeaponType(WEAPON_TYPE);

        personaEntity = new Persona();
        personaEntity.setId(ID);
        personaEntity.setName(NAME);
        personaEntity.setArcana(ARCANA);
        personaEntity.setStrengths(STRENGTHS);
        personaEntity.setWeaknesses(WEAKNESSES);

        personaDTO = new PersonaDTO();
        personaDTO.setId(ID);
        personaDTO.setName(NAME);
        personaDTO.setArcana(ARCANA);
        personaDTO.setStrengths(STRENGTHS);
        personaDTO.setWeaknesses(WEAKNESSES);

        personaUserEntity = new PersonaUser();
        personaUserEntity.setId(ID);
        personaUserEntity.setName(NAME);
        personaUserEntity.setLastName(LAST_NAME);
        personaUserEntity.setArcana(ARCANA);
        personaUserEntity.setGame(GAME);
        personaUserEntity.setWildCard(WILD_CARD);

        personaUserDTO = new PersonaUserDTO();
        personaUserDTO.setId(ID);
        personaUserDTO.setName(NAME);
        personaUserDTO.setLastName(LAST_NAME);
        personaUserDTO.setArcana(ARCANA);
        personaUserDTO.setGame(GAME);
        personaUserDTO.setWildCard(WILD_CARD);
    }

}
