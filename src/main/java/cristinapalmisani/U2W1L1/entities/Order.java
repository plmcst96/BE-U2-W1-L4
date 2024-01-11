package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Random;

@Entity
@Getter
@Setter
@Component
@NoArgsConstructor
@PropertySource("application.properties")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int orderNumber;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private Table table;

    @Enumerated(EnumType.STRING)
    private OrderState orderState = OrderState.IN_PROGRESS;
    private int seats;
    private LocalTime orderTime = LocalTime.now();
    @Value("${order.seat}")
    private double priceSeat;

    public Order(int orderNumber, Menu menu, Table table, int seats) {
        this.orderNumber = orderNumber;
        this.menu = menu;
        this.table = table;
        this.seats = seats;
    }

    public void setTable(Table table) {
        Random rnd = new Random();
        table.setAvailable(false);
        this.table = table;
        seats = rnd.nextInt(table.getSeats()) + 1;
    }

    public double getTotal() {
        return menu.getPrice() + seats * priceSeat;
    }

    public void printOrder() {
        System.out.println("Order number: " + orderNumber);
        System.out.println("Table number: " + table.getNumberTable());
        System.out.println("Seats: " + seats + " / " + table.getSeats());
        System.out.println("Order time: " + orderTime);
        System.out.println("Order state: " + orderState);
        System.out.println("Seats price: " + priceSeat);
        System.out.println();
        System.out.println("Detail order");
        menu.getPizzasList().forEach(System.out::println);
        menu.getDrinksList().forEach(System.out::println);
        System.out.println("Order price: " + getTotal());
        System.out.println();
    }
}
