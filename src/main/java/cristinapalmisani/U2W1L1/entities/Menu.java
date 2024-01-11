package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Entity
@Table(name = "menu")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "pizze")
    @OneToMany(mappedBy = "menu")
    private List<Pizzas> pizzasList;
    @Column(name = "bevande")
    @OneToMany(mappedBy = "menu")
    private List<Drinks> drinksList;
    @OneToMany(mappedBy = "menu")
    @Column(name = "condimenti")
    private List<Toppings> toppingList;
    @OneToMany(mappedBy = "menu")
    private List<Order> orders;

    public Menu(List<Pizzas> pizzasList, List<Drinks> drinksList, List<Toppings> toppingList) {
        this.pizzasList = pizzasList;
        this.drinksList = drinksList;
        this.toppingList = toppingList;
    }

    public void printMenu() {
        System.out.println("******* Menu *******");
        System.out.println("PIZZAS");
        this.pizzasList.forEach(System.out::println);
        System.out.println();

        System.out.println("TOPPINGS");
        this.toppingList.forEach(System.out::println);
        System.out.println();

        System.out.println("DRINKS");
        this.drinksList.forEach(System.out::println);
        System.out.println();

    }

    public double getPrice() {
        double totalPrice = 0;
        for (Pizzas pizza : pizzasList) {
            totalPrice += pizza.getPrice();
        }
        for (Drinks drink : drinksList) {
            totalPrice += drink.getPrice();
        }
        return totalPrice;
    }

    public void setDrinksList(Drinks water, AlcolicDrink beer) {
    }

}
