package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pizze")
@Getter
@Setter
@NoArgsConstructor
public class Pizzas extends MenuItem {
    @ManyToMany
    @JoinTable(name = "pizze_type",
            joinColumns = @JoinColumn(name = "pizze_id"),
            inverseJoinColumns = @JoinColumn(name = "toppings_id"))
    private List<Toppings> toppings;
    @ManyToOne
    private Menu menu;

    public Pizzas(String name, int calories, double price, List<Toppings> toppings) {
        super(name, calories, price);
        this.toppings = toppings;
    }

  @Override
    public String toString() {
        return "Pizza{" +
                "name=" + getName() + '\'' +
                ", calories=" + getCalories() +
                ", price=" + getPrice() +
                ", toppingList=" + getToppings() +
                '}';
    }
}
