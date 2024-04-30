package coffee.order;

public class Order {
    private final int id;
    private final String clientName;


    public Order(int id, String clientName) {
        this.clientName = clientName;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getClient() {
        return clientName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", Client name:'" + clientName + '\'' +
                '}';
    }

}
