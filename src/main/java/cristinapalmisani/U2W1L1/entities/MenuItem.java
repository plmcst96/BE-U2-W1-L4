package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MenuItem {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int calories;
    private double price;

    public MenuItem(String name, int calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }
}