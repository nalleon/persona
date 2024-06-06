package es.ies.puerto.business.dto;

import java.util.Objects;
/**
 * @author mackstm
 * @author nalleon
 */
public class EquipmentDTO {
    /**
     * Properties
     */
    private int id;
    private String weaponName;
    private String weaponType;
    private int shopPrice;

    /**
     * Default constructor of the class
     */
    public EquipmentDTO() {}

    /**
     * Constructor of the class
     * @param id of the EquipmentDTO
     */
    public EquipmentDTO(int id) {
        this.id = id;
    }

    /**
     * Constructor of the class
     * @param id of the EquipmentDTO
     * @param weaponName of the EquipmentDTO
     * @param weaponType of the EquipmentDTO
     * @param shopPrice of the EquipmentDTO
     */

    public EquipmentDTO(int id, String weaponName, String weaponType, int shopPrice) {
        this.id = id;
        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.shopPrice = shopPrice;
    }

    public int getId() {
        return id;
    }

    /**
     * Getters and setters
     */
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
        EquipmentDTO equipmentDTO = (EquipmentDTO) o;
        return id == equipmentDTO.id;
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
