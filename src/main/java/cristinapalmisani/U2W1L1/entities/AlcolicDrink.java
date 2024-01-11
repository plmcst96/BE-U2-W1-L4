package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "alcool_drinks")
@Getter
@Setter
public class AlcolicDrink extends Drinks{

    private double alcoolperc;

    public AlcolicDrink(String name, int calories, double price, double litre, double alcoolperc) {
        super(name, calories, price, litre);
        this.alcoolperc = alcoolperc;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + getName() + '\'' +
                ", calories=" + getCalories() +
                ", price=" + getPrice() +
                ", litre=" + getLitre() + "l" + ", alcool=" + getAlcoolperc() + "%" +
                '}';
    }
}
