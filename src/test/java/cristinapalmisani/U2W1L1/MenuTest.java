package cristinapalmisani.U2W1L1;

import ch.qos.logback.classic.spi.ILoggingEvent;
import cristinapalmisani.U2W1L1.entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MenuTest {
private static AnnotationConfigApplicationContext ctx;
private Menu menu;

	@BeforeAll
	static void beforeAll() {
		ctx = new AnnotationConfigApplicationContext(U2W1L1Application.class);
	}
	@BeforeEach
	void beforeEach() {
		List<Drinks> drinks = new ArrayList<>();
		List<Pizzas> pizzas = new ArrayList<>();
		List<Toppings> toppings = new ArrayList<>();
		menu = new Menu(pizzas, drinks, toppings);
	}
	@Test
	void testDrinkPrice() {
		Drinks water = ctx.getBean("water", Drinks.class);
		AlcolicDrink beer = ctx.getBean("beer", AlcolicDrink.class);
		double tot = water.getPrice() + beer.getPrice();
		assertEquals(5, tot);
		System.out.println("CORRETTO");
	}

	@Test
	void testTotalOrder(){
		Menu menu = ctx.getBean("menu", Menu.class);
      	Order o1 = new Order(menu);
	  	assertEquals(39.5, o1.getTotal() );
	}

	@ParameterizedTest
	@CsvSource({"salamiPizza, 1160", "margherita, 1104"})
	public void testPizzeParam(String nomePizza, int expectedCalories) {
		Pizzas pizza = ctx.getBean(nomePizza, Pizzas.class);
		assertEquals(expectedCalories, pizza.getCalories());
	}

	@ParameterizedTest
	@CsvSource({"tomato, 20", "onions, 22", "pineapple, 24"})
	public void testToppingCalories(String nomeTopping, int expectedCalories) {
		Toppings toppings = ctx.getBean(nomeTopping, Toppings.class);
		assertEquals(expectedCalories, toppings.getCalories());
	}

}
