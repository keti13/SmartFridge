package ge.gtu.smartfridgewebapp;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Food")
public class Food {
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String expirationDate;
    private int calories;
    private int quantity;

    public Food(){

    }

    public Food(String name, String expirationDate, int calories, int quantity) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.calories = calories;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", calories=" + calories + '\'' +
                ", quantity=" + quantity + '\'' +
                '}';
    }
    /* Used for testing */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (id != food.id) return false;
        if (calories != food.calories) return false;
        if (quantity != food.quantity) return false;
        if (expirationDate != food.expirationDate) return false;
        if (!Objects.equals(name, food.name)) return false;


        return true;
    }
}
