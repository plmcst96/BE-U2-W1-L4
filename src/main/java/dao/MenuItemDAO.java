package dao;

import cristinapalmisani.U2W1L1.entities.MenuItem;
import cristinapalmisani.U2W1L1.entities.Pizzas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemDAO extends JpaRepository<MenuItem, Long> {
}
