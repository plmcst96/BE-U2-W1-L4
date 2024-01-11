package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "condimenti")
@Getter
@Setter
@NoArgsConstructor
public class Toppings extends MenuItem{
    @ManyToMany
    @JoinTable(name = "pizze_type",
            joinColumns = @JoinColumn(name = "toppings_id"),
            inverseJoinColumns = @JoinColumn(name = "pizze_id"))
    private List<Pizzas> pizze;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    public Toppings(String name, int calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + getName() + '\'' +
                ", calories=" + getCalories() +
                ", price=" + getPrice() +
                '}';
    }
}
