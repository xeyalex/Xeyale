package Solid;

    public class OrderProcessing {
        private DiscountStrategy discountStrategy;
        private ShippingStrategy shippingStrategy;

        public OrderProcessing(DiscountStrategy discountStrategy, ShippingStrategy shippingStrategy) {
            this.discountStrategy = discountStrategy;
            this.shippingStrategy = shippingStrategy;
        }

        public double calculateTotalPrice(Product product) {
            double discountedPrice = discountStrategy.applyDiscount(product.getPrice());
            double shippingCost = shippingStrategy.calculateShippingCost(product);
            return discountedPrice + shippingCost;
        }
    }


