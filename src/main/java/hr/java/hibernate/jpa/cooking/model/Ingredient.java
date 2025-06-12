package hr.java.hibernate.jpa.cooking.model;

import jakarta.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    Meal meal = new Meal();

    public Ingredient(String name) {
        this.name = name;
    }

    @JoinColumn(name = "meal_id")

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
