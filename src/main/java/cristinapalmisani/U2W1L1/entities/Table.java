package cristinapalmisani.U2W1L1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Data
public class Table {
    @Id
    @GeneratedValue
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
