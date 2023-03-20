package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {

      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"),new Car("Lada",2107));
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"),new Car("Lada",2107));
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"),new Car("Lada",2107));
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"),new Car("Lada",2107));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      List<Car> cars = userService.carList();
      for (Car car:cars) {
         System.out.println(("id="+car.getId()));
         System.out.println("model = "+car.getModel());
         System.out.println("series = "+car.getSeries());
         System.out.println();
      }

      context.close();
   }

}
