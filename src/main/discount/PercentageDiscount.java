package main.discount;

public class PercentageDiscount implements DiscountStrategy {
    private float discountPercentage;

    public PercentageDiscount(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public float applyDiscount(float totalPrice) {
        return totalPrice * (1 - discountPercentage);
    }
    
}
