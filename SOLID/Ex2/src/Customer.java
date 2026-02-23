public class Customer implements Taxable, Discountable {
    @Override
    public double taxPercent() {
        return 8.0;
    }

    @Override
    public double discountAmount(double subtotal, int distinctLines) {
        return 0.0;
    }
}
