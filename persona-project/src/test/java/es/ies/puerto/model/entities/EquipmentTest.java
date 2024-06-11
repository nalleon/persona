package es.ies.puerto.model.entities;

import es.ies.puerto.model.entities.impl.Equipment;
import es.ies.puerto.utilities.UtilitiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipmentTest extends UtilitiesTest {

    public static final int ID = 1;
    public static final String NAME = "nameTest";
    public static final int SHOP_PRICE = 1234;
    public static final String WEAPON_TYPE = "weaponTypeTest";
    Equipment equipment;
    @BeforeEach
    public void beforeEach(){
        equipment = new Equipment();
        equipment.setId(ID);
        equipment.setWeaponName(NAME);
        equipment.setShopPrice(SHOP_PRICE);
        equipment.setWeaponType(WEAPON_TYPE);
    }

    @Test
    public void getSetTest(){
        Assertions.assertEquals(ID, equipment.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(NAME, equipment.getWeaponName(), MESSAGE_ERROR);
        Assertions.assertEquals(SHOP_PRICE, equipment.getShopPrice(), MESSAGE_ERROR);
        Assertions.assertEquals(WEAPON_TYPE, equipment.getWeaponType(), MESSAGE_ERROR);
    }

    @Test
    public void equalsTest(){
        Equipment equalsObject = new Equipment(ID);
        Equipment notEquals = new Equipment(34, NAME, WEAPON_TYPE, SHOP_PRICE);
        String str = "strTest";
        Equipment nullObject = null;

        Assertions.assertEquals(equalsObject.hashCode(), equipment.hashCode(), MESSAGE_ERROR);
        Assertions.assertEquals(equalsObject, equipment, MESSAGE_ERROR);
        Assertions.assertTrue(equipment.equals(equalsObject), MESSAGE_ERROR);
        Assertions.assertTrue(equipment.equals(equipment), MESSAGE_ERROR);
        Assertions.assertFalse(equipment.equals(notEquals), MESSAGE_ERROR);
        Assertions.assertFalse(equipment.equals(nullObject), MESSAGE_ERROR);
        Assertions.assertFalse(equipment.equals(str), MESSAGE_ERROR);
    }

    @Test
    public void toStringTest(){
        Assertions.assertTrue(equipment.toString().contains(String.valueOf(ID)), MESSAGE_ERROR);
        Assertions.assertTrue(equipment.toString().contains(NAME), MESSAGE_ERROR);
        Assertions.assertTrue(equipment.toString().contains(String.valueOf(SHOP_PRICE)), MESSAGE_ERROR);
        Assertions.assertTrue(equipment.toString().contains(WEAPON_TYPE), MESSAGE_ERROR);
    }
}
