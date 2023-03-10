package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("car1", 6);
      Car car2 = new Car("car2", 2);
      Car car3 = new Car("Car3", 3);
      Car car4 = new Car("Car4", 4);

      User user1 = new User("user1", "lastname1", "user1@mail.ru",car1);
      User user2 = new User("user2", "lastname2", "user2@mail.ru",car2);
      User user3 = new User("user3", "lastname3", "user3@mail.ru",car3);
      User user4 = new User("user4", "lastname4", "user4@mail.ru",car4);

      car1.setUserbyId(user1);
      car2.setUserbyId(user2);
      car3.setUserbyId(user3);
      car4.setUserbyId(user4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      System.out.println(users);
      System.out.println(userService.getUserCar("car1", 1));
      context.close();
   }
}
