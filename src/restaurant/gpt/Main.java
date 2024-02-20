package restaurant.gpt;

import java.util.ArrayList;
import java.util.List;

// Menu Element class
class MenuElement {
    private String name;
    private double price;

    public MenuElement(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Menu Category class
class MenuCategory {
    private String name;
    private List<MenuElement> elements;

    public MenuCategory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void addElement(MenuElement element) {
        elements.add(element);
    }

    public List<MenuElement> getElements() {
        return elements;
    }

    public String getName() {
        return name;
    }
}

// Restaurant Menu class
class RestaurantMenu {
    private List<MenuCategory> categories;

    public RestaurantMenu() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(MenuCategory category) {
        categories.add(category);
    }

    public List<MenuCategory> getCategories() {
        return categories;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating the restaurant menu
        RestaurantMenu restaurantMenu = new RestaurantMenu();

        // Creating categories
        MenuCategory saladCategory = new MenuCategory("Salads");
        MenuCategory mainDishCategory = new MenuCategory("Main Dishes");

        // Creating menu elements
        MenuElement caesarSalad = new MenuElement("Caesar Salad", 12.99);
        MenuElement olivyeSalad = new MenuElement("Olivye Salad", 10.99);
        MenuElement manti = new MenuElement("Manti", 15.99);
        MenuElement lagman = new MenuElement("Lagman", 18.99);

        // Adding elements to categories
        saladCategory.addElement(caesarSalad);
        saladCategory.addElement(olivyeSalad);

        mainDishCategory.addElement(manti);
        mainDishCategory.addElement(lagman);

        // Adding categories to the menu
        restaurantMenu.addCategory(saladCategory);
        restaurantMenu.addCategory(mainDishCategory);

        // Printing the menu
        List<MenuCategory> categories = restaurantMenu.getCategories();
        for (MenuCategory category : categories) {
            System.out.println("Category: " + category.getName());
            // Printing elements
            List<MenuElement> elements = category.getElements();
            for (MenuElement element : elements) {
                System.out.println("Element: " + element.getName() + ", Price: $" + element.getPrice());
            }
            System.out.println();
        }
    }
}
