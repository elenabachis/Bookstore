package main.discount;

public class NoDiscount implements DiscountStrategy {

    @Override
    public float applyDiscount(float totalPrice) {
        // Implement the no discount strategy
        return totalPrice;
    }
}
