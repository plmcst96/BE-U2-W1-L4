package cristinapalmisani.U2W1L1;

import cristinapalmisani.U2W1L1.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class U2W1L1Application {

	public static void main(String[] args) {
		SpringApplication.run(U2W1L1Application.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U2W1L1Application.class);

		Menu menu = (Menu) ctx.getBean("menu");

		menu.printMenu();
		ctx.close();
	}

}
