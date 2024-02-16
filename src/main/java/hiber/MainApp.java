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
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(new Car("model1", (long) 1));
      userService.add(user1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(new Car("model2", (long) 2));
      userService.add(user2);

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(new Car("model3", (long) 3));
      userService.add(user3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(new Car("model4", (long) 4));
      userService.add(user4);

      System.out.println("Искомый владелец машины: " + userService.getUserByCar("model3", (long) 3));
      System.out.println();

      List<User> users = userService.listUsers();
      System.out.println("Все зарегистрированные владельцы:");
      System.out.println();
      for (User user : users) {
         System.out.println(user);
      }

      context.close();
   }
}
