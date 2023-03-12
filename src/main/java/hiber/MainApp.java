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



      User user1 = new User("user1", "lastname1", "user1@mail.ru",new Car("mazda",1));
      User user2 = new User("user2", "lastname2", "user2@mail.ru",new Car("lada",2));
      User user3 = new User("user3", "lastname3", "user3@mail.ru",new Car("kia",3));
      User user4 = new User("user4", "lastname4", "user4@mail.ru",new Car("mers",4));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      System.out.println(users);
      System.out.println("User with car" + userService.getUserCar("mazda", 1));
      context.close();
   }
}
