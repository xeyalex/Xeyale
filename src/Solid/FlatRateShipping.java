package Solid;

    public class FlatRateShipping implements ShippingStrategy {
        private double rate;

        public FlatRateShipping(double rate) {
            this.rate = rate;
        }

        @Override
        public double calculateShippingCost(Product product) {
            // For simplicity, assume flat rate shipping cost calculation
            return rate;
        }
    }


