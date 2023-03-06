package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;
   @OneToOne (cascade = CascadeType.ALL, mappedBy = "user")
   private Car car;

   public Car getCar() {
      return car;
   }

   public String getFirstName() {
      return firstName;
   }

   public User() {}

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }


   public User (Car car) {
      this.car=car;
   }
   public Car setCar(Car car) {
      this.car=car;
      return car;
   }
   @Override
   public String toString() {
      return "User {" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
