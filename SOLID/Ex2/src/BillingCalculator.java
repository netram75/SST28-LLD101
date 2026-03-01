import java.util.Map;
import java.util.List;

public class BillingCalculator {

    public double calculateSubtotal(Map<String, MenuItem> menu, List<OrderLine> lines) {
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }

        return subtotal;
    }

    public double calculateTax(double subtotal, String customerType) {
        double taxPct = TaxRules.taxPercent(customerType);
        return subtotal * (taxPct / 100.0);
    }

    public double calculateDiscount(String customerType, double subtotal, int distinctLines) {
        return DiscountRules.discountAmount(customerType, subtotal, distinctLines);
    }

    public double calculateTotal(double subtotal, double tax, double discount) {
        return subtotal + tax - discount;
    }
}
