package fr.nirahtech.devops;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Drink implements ShortDrinkDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    Float degrees;
    BigDecimal price;
    String image;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the degrees
     */
    public Float getDegrees() {
        return degrees;
    }
    /**
     * @param degrees the degrees to set
     */
    public void setDegrees(Float degrees) {
        this.degrees = degrees;
    }
    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }
    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean isAlcool() {
        return this.degrees > 0;
    }

}
