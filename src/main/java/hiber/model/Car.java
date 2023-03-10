package hiber.model;

import javax.persistence.*;

@Entity
@Table (name ="cars")
public class Car {
    @Column(name = "model")
    private String model;
    @Column (name = "series")
    private int series;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name ="userId")
    private User user;

    public Car() {

    }
    public Car(String model, int series) {
        this.model = model;
        this.series=series;
    }
    public void setUserbyId ( User user) {
        this.user=user;
    }

    @Override
    public String toString() {
        return "Car {" + "id=" + id + ", model='" + model + '\'' + ", series=" + series + '}';
    }
}
//я совсем сломал голову, как сделать связь через конструкторы. они же выходят цикличные
//если у нас конструктор юзеров требует кар и конструктор каров требует юзера, то как их ввести даже через бины?
