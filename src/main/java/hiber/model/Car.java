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
    public User getUser() {
        return user;
    }

    public User setUser(User user) {
        this.user = user;
        return user;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Car {" + "id=" + id + ", model='" + model + '\'' + ", series=" + series + '}';
    }
}
