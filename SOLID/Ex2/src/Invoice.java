import java.util.List;

public class Invoice {
    private final String id;
    private final List<InvoiceItem> items;
    private final double subtotal;
    private final double taxAmount;
    private final double taxPct;
    private final double discountAmount;
    private final double discountPct;
    private final double total;

    public Invoice(String id, List<InvoiceItem> items, double subtotal, double tax, double taxPct, double discount,
            double discountPct, double total) {
        this.id = id;
        this.items = items;
        this.subtotal = subtotal;
        this.taxAmount = tax;
        this.taxPct = taxPct;
        this.discountAmount = discount;
        this.discountPct = discountPct;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getTaxPercent() {
        return taxPct;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        return discountPct;
    }

    public double getTotal() {
        return total;
    }
}
