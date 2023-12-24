import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var productList = new ArrayList<Product>();
        productList.add(new Product("Apple keyboard", 125));
        productList.add(new Product("Apple Mouse", 60));
        productList.add(new Product("Apple Iphone 15", 1200));

        var myOrder = new ArrayList<OrderItem>();
        myOrder.add(new OrderItem(productList.get(2), 1));
        myOrder.add(new OrderItem(productList.get(1), 2));
        Product.printOrder(myOrder);

    }
}

