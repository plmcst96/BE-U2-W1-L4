package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Data
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int numberTable;
    private final int seats;
    private boolean isAvailable;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;

    public Table(int numberTable, int seats) {
        this.numberTable = numberTable;
        this.seats = seats;
        this.isAvailable = true;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
