public class InvoiceItem {
    public final String name;
    public final int quantity;
    public final double lineTotal;

    public InvoiceItem(String name, int quantity, double lineTotal) {
        this.name = name;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }
}
