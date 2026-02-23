public class StaffCustomer extends Customer {
    @Override
    public double taxPercent() {
        return 2.0;
    }

    @Override
    public double discountAmount(double subtotal, int distinctLines) {
        if (distinctLines >= 3) {
            return 15.0;
        }
        return 5.0;
    }
}
