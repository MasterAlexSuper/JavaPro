package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    Queue<Order> orders = new LinkedList<>();
    private int ordersCounter = 0;


    public void add(String clientName) {
        orders.add(new Order(++ordersCounter, clientName));
    }


    public void deliver() {
        if (orders.isEmpty()) {
            System.out.println("There are no more orders to deliver");
            return;
        }
        Order order = orders.remove();
        System.out.println(order + " was delivered");
    }

    public void deliver(int id) {
        if (orders.isEmpty()) {
            System.out.println("There are no more orders to deliver");
            return;
        }
        Queue<Order> newOrders = new LinkedList<>();
        for (Order order : orders) {
            if (order.getId() != id) {
                newOrders.add(order);
            }else System.out.println(order + " was delivered");
        }
        if (orders.size() == newOrders.size()) {
            System.out.println("Order with id " + id + " does`t exist");
        }
        orders = newOrders;

    }

    public void draw(){
        if (orders.isEmpty()) {
            System.out.println("There are no orders");
            return;
        }
        System.out.println("==========");
        System.out.println("Id | Name");
        for (Order order : orders) {
            System.out.println(order.getId() + " | " + order.getClient());
        }
        System.out.println("==========");
    }


    @Override
    public String toString() {
        return "CoffeeOrderBoard{" +
                "first Order=" + orders.peek() +
                ", orderCount=" + ordersCounter +
                '}';
    }




    public CoffeeOrderBoard() {}



    public static void main(String[] args) {

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.draw();

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
