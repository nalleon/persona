package es.ies.puerto.model.entities.impl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * @author mackstm
 * @author nalleon
 */
@Document("Equipment")
public class Equipment {
    /**
     * Properties
     */
    @Id
    private int id;
    private String weaponName;
    private String weaponType;
    private int shopPrice;

    /**
     * Default constructor of the class
     */
    public Equipment() {}

    /**
     * Constructor of the class
     * @param id of the Equipment
     */

    public Equipment(int id) {
        this.id = id;
    }

    /**
     * Constructor of the class
     * @param id of the Equipment
     * @param weaponName of the Equipment
     * @param weaponType of the Equipment
     * @param shopPrice of the Equipment
     */
    public Equipment(int id, String weaponName, String weaponType, int shopPrice) {
        this.id = id;
        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.shopPrice = shopPrice;
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

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public int getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(int shopPrice) {
        this.shopPrice = shopPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return id == equipment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", weaponName='" + weaponName + '\'' +
                ", weaponType='" + weaponType + '\'' +
                ", shopPrice=" + shopPrice +
                '}';
    }
}
