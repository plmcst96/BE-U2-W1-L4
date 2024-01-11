package dao;

import cristinapalmisani.U2W1L1.entities.Pizzas;
import exception.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MenuItemService {
    @Autowired
    private MenuItemDAO menuItemDAO;

    public void savePizza(Pizzas pizza){
       menuItemDAO.save(pizza);
       log.info("Pizza salvata correttamente");
    }

    public Pizzas findById(long id) throws ItemNotFoundException {
        return (Pizzas) menuItemDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }
}
