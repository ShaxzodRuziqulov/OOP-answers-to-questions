package shop;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private final double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}

class Order {
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return product.getCost() * quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}

class Customer {
    private final String name;
    private final String address;
    private final List<Order> orders;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Product product, int quantity) {
        Order order = new Order(product, quantity);
        orders.add(order);
        System.out.println("Order placed " + order);
    }

    public void calculateTotal() {
        double sum = 0;
        for (Order order :
                orders) {
            sum += order.calculateTotal();
        }
        System.out.println("Total count : $ " + sum);
    }

    public void orders() {
        System.out.println("Orders:");
        for (Order o :
                orders) {
            System.out.println(o);
        }
    }



    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Phone",1200);
        Product product1 = new Product("Phone1",1300);

        Customer customer = new Customer("Ali","Tashkent");

        customer.placeOrder(product,1);
        customer.placeOrder(product1,1);

        customer.orders();

        customer.calculateTotal();
    }
}
