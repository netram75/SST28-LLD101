public class StudentCustomer extends Customer {
    @Override
    public double taxPercent() {
        return 5.0;
    }

    @Override
    public double discountAmount(double subtotal, int distinctLines) {
        if (subtotal >= 180.0) {
            return 10.0;
        }
        return 0.0;
    }
}
