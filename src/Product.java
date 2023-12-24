import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static java.lang.StringTemplate.STR;

public record Product (String name, double price) {

    public static void printOrder(List<OrderItem> items) {
        System.out.println(sep() + " order summary ".toUpperCase(Locale.ROOT) + sep());
        items.forEach(Product::showInvoice);

        var total = items.stream().reduce(0.0, (res, prod) -> res + calcPrice(prod.qty(), prod.product().price), Double::sum);
        System.out.println(STR."total cost is \{formatMoney(total)}");


    }

    private static String formatMoney(double amount) {
        return NumberFormat.getCurrencyInstance(Locale.UK).format(amount);
    }

    private static double calcPrice(int qty, double price) {
        return qty * price;

    }

    private static String sep() {
        return "-".repeat(20);

    }

    private static void showInvoice(OrderItem item) {
        var p = item.product();
        System.out.println(p.name);
        System.out.println(p.price);
        System.out.println(STR."Quantity: \{item.qty()}");
        System.out.println(Product.sep());
    }



}
