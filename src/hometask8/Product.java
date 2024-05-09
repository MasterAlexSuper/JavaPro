package hometask8;

import java.time.LocalDateTime;


public class Product {
    private String type;
    private int price;
    private int discount;
    private final LocalDateTime creationDate = LocalDateTime.now();

    public Product(String type, int price, int discount) {
        this.type = type;
        this.price = price - price * discount / 100;
        this.discount = discount;
    }

    public Product(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
