package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "bevande")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
public class Drinks extends MenuItem{

    private double litre;
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    public Drinks(String name, int calories, double price, double litre) {
        super(name, calories, price);
        this.litre = litre;
    }

    public Drinks(String name, int calories, double price, double litre, Menu menu) {
        super(name, calories, price);
        this.litre = litre;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + getName() + '\'' +
                ", calories=" + getCalories() +
                ", price=" + getPrice() +
                ", litre=" + getLitre() + "l" +
                '}';
    }

}
