package Solid;


    public class PercentageDiscount implements DiscountStrategy {
        private double percentage;

        public PercentageDiscount(double percentage) {
            this.percentage = percentage;
        }

        @Override
        public double applyDiscount(double originalPrice) {
            return originalPrice * (1 - percentage / 100);
        }
    }


