package pl.training.shop.payments;

import lombok.Setter;

public class IncrementalPaymentIdGenerator implements PaymentIdGenerator{

    public static final String FORMAT = "%010d";

    @Setter
    private long index;

    @Override
    public String getNext() {
        return String.format(FORMAT, ++index);
    }
}
