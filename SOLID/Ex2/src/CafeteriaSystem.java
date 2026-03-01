import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceRepository store;
    private final BillingCalculator calculator = new BillingCalculator();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public CafeteriaSystem(InvoiceRepository store) {
    this.store = store;
    }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {

    String invId = "INV-" + (++invoiceSeq);

    double subtotal = calculator.calculateSubtotal(menu, lines);
    double tax = calculator.calculateTax(subtotal, customerType);
    double discount = calculator.calculateDiscount(customerType, subtotal, lines.size());
    double total = calculator.calculateTotal(subtotal, tax, discount);

    double taxPct = TaxRules.taxPercent(customerType);

    String printable = InvoiceFormatter.format(
            invId,
            menu,
            lines,
            subtotal,
            taxPct,
            tax,
            discount,
            total
    );

    System.out.print(printable);

    store.save(invId, printable);
    System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
}
}