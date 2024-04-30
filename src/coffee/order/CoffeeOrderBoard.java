package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    Queue<Order> orders = new LinkedList<>();
    private int ordersCounter = 0;


    public void add(String clientName) {
        orders.add(new Order(++ordersCounter, clientName));
    }


    public boolean isNotEmpty() {
        if (orders.isEmpty()) {
            System.out.println("There are no orders");
            return false;
        } else {
            return true;
        }
    }

    public void deliver() {
        if (isNotEmpty()) {
            Order order = orders.remove();
            System.out.println(order + " was delivered");
        }
    }

    public void deliver(int id) {
        if (isNotEmpty()) {
            orders.removeIf(order -> {
                if (order.getId() == id) {
                    System.out.println(order + " was delivered");
                    return true;
                }
                return false;
            });
        }
    }

    public void draw() {
        if (isNotEmpty()) {
            System.out.println("==========");
            System.out.println("Id | Name");
            for (Order order : orders) {
                System.out.println(order.getId() + " | " + order.getClient());
            }
            System.out.println("==========");
        }
    }

    @Override
    public String toString() {
        return "CoffeeOrderBoard{" +
                "first Order=" + orders.peek() +
                ", orderCount=" + ordersCounter +
                '}';
    }


    public CoffeeOrderBoard() {
    }


    public static void main(String[] args) {

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver(1);

        coffeeOrderBoard.add("Alex");
        coffeeOrderBoard.add("Kirill");
        coffeeOrderBoard.add("Anton");
        coffeeOrderBoard.add("Sasha");
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver(3);
        coffeeOrderBoard.draw();
    }
}
