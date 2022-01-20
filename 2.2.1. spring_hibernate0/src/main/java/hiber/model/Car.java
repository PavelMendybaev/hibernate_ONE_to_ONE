package hiber.model;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String model;
    @Column
    private int series;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "car")
    private User user ;


    public Car(String model , int series){
        this.model = model;
        this.series = series;
    }

    public Car() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
