package hr.java.hibernate.jpa.cooking;

import hr.java.hibernate.jpa.cooking.model.Ingredient;
import hr.java.hibernate.jpa.cooking.model.Meal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryCooking");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Ingredient ingredient1 = new Ingredient("Paprika");
        Ingredient ingredient2 = new Ingredient("Luk");
        Ingredient ingredient3 = new Ingredient("Junetina");
        Ingredient ingredient4 = new Ingredient("Svinjetina");
        Ingredient ingredient5 = new Ingredient("Divljač");

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        ingredients.add(ingredient5);

        Meal meal1 = new Meal();
        meal1.setName("Čobanac");
        meal1.setIngredients(ingredients);
        em.persist(meal1);

        Ingredient ingredientFish3 = new Ingredient("Šaran");
        Ingredient ingredientFish4 = new Ingredient("Štuka");
        Ingredient ingredientFish5 = new Ingredient("Smuđ");

        List<Ingredient> ingredientsFish = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredientFish3);
        ingredients.add(ingredientFish4);
        ingredients.add(ingredientFish5);

        Meal meal2 = new Meal();
        meal2.setName("Fiš");
        meal2.setIngredients(ingredientsFish);
        em.persist(meal2);

        List<Meal> meals = em.createQuery("SELECT b FROM Meal b", Meal.class).getResultList();
        ingredients = em.createQuery("SELECT b FROM Ingredient b", Ingredient.class).getResultList();

        for (Meal meal : meals) {
            System.out.println("Meal: " + meal.getName() + " ima sastojke: " + meal1.getIngredients().toString());
        }

    }
}
