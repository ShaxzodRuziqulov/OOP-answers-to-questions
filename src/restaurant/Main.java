package restaurant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Menu Element class
record MenuElement(String name, double price) {
}

// Menu Category class
class MenuCategory {
    private final String name;
    private final List<MenuElement> elements;

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
    private final List<MenuCategory> categories;

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
        Scanner scanner = new Scanner(System.in);
        // Creating the restaurant menu
        RestaurantMenu restaurantMenu = new RestaurantMenu();

        // Creating categories
        System.out.println("kategoriyani kiriting");
        String nameC = scanner.next();
        MenuCategory saladCategory = new MenuCategory(nameC);
        MenuCategory mainDishCategory = new MenuCategory(nameC);

        // Creating menu elements
        System.out.println(" tanlang ,nomi va narxi");
        String nameE = scanner.next();
        double costE = scanner.nextDouble();
        MenuElement caesarSalad = new MenuElement(nameE, costE);
        MenuElement olivyeSalad = new MenuElement(nameE, costE);
        MenuElement manti = new MenuElement(nameE, costE);
        MenuElement lagman = new MenuElement(nameE, costE);

        // Adding elements to categorize
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
                System.out.println("Element: " + element.name() + ", Price: $" + element.price());
            }
            System.out.println();
        }
    }
}

