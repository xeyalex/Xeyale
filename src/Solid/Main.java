package Solid;

    public class Main {
        public static void main(String[] args) {
            Product product = new Product("Laptop", 1000);

            DiscountStrategy discountStrategy = new PercentageDiscount(20);

            ShippingStrategy shippingStrategy = new FlatRateShipping(10);

            OrderProcessing orderProcessing = new OrderProcessing(discountStrategy, shippingStrategy);

            double totalPrice = orderProcessing.calculateTotalPrice(product);

            System.out.println("Total Price: $" + totalPrice);
        }
    }


