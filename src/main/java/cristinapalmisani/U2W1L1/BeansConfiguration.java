package cristinapalmisani.U2W1L1;

import cristinapalmisani.U2W1L1.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Configuration
public class BeansConfiguration {

    @Bean
   public Toppings cheese (){
        return new Toppings("Cheese", 92, 0.69);
    }

    @Bean
    public  Toppings ham(){
        return  new Toppings("Ham", 35, 0.99);
    }

    @Bean
    public Toppings onions(){
        return new Toppings("Onions", 22, 0.69);
    }

    @Bean
    public  Toppings pineapple(){
        return new Toppings("Pineapple", 24, 0.79);
    }

    @Bean
    public  Toppings salami(){
        return new Toppings("Salami", 86, 0.99);
    }

    @Bean
    public  Toppings tomato(){
        return new Toppings("Tomato", 20, 0.79);
    }

    @Bean
    public Drinks lemonade(){
        return new Drinks("Lemonade", 128, 1.50, 0.33);
    }

    @Bean
    public Drinks water(){
        return new Drinks("Water", 0, 1, 0.5);
    }


    @Bean
    public Drinks cocaCola(){
        return new Drinks("Coca-cola", 124, 2, 0.33);
    }
    @Bean
    public AlcolicDrink wine(){
        return new AlcolicDrink("Wine", 607, 8, 0.75, 13);
    }

    @Bean
    public AlcolicDrink beer(){
        return new AlcolicDrink("Beer", 500, 4, 0.5, 7);
    }

    @Bean
    public Pizzas margherita(){
        return new Pizzas("Pizza Margherita", 1104, 5, Arrays.asList(tomato(), cheese()));
    }
    @Bean
    public Pizzas hawaiian(){
        return new Pizzas("Hawaiian Pizza", 1024, 7, Arrays.asList(tomato(), cheese(), ham(), pineapple()));
    }

    @Bean
    public Pizzas salamiPizza(){
        return new Pizzas("Salami Pizza", 1160, 6, Arrays.asList(tomato(), cheese(), salami()));
    }
    @Bean
    public Pizzas onionPizza(){
        return new Pizzas("Onion Pizza", 1000, 5, Arrays.asList(tomato(), cheese(), onions()));
    }
@Bean
    public Menu menu(){
        List<Pizzas> pizzaList = new ArrayList<>();
        List<Drinks> drinkList = new ArrayList<>();
        List<Toppings> toppingsList = new ArrayList<>();

        pizzaList.add(margherita());
        pizzaList.add(hawaiian());
        pizzaList.add(salamiPizza());
        pizzaList.add(onionPizza());

        drinkList.add(lemonade());
        drinkList.add(water());
        drinkList.add(wine());
        drinkList.add(beer());
        drinkList.add(cocaCola());

        toppingsList.add(tomato());
        toppingsList.add(cheese());
        toppingsList.add(onions());
        toppingsList.add(ham());
        toppingsList.add(salami());
        toppingsList.add(pineapple());

        return new Menu(pizzaList, drinkList, toppingsList);
    }

    @Bean
    public Table getTable(){
        Random rndm = new Random();
        return new Table(rndm.nextInt(12) + 1, rndm.nextInt(10) + 2);
    }
    }

