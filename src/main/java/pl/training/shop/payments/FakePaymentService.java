package pl.training.shop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.time.Instant;

@Log
@RequiredArgsConstructor
public class FakePaymentService {

    public static final String LOG_FORMAT = "A new payment of %s has been initiated";

    private final PaymentIdGenerator paymentIdGenerator;

    public Payment process(PaymentRequest paymentRequest){
        var payment = Payment.builder()
                .id(paymentIdGenerator.getNext())
                .money(paymentRequest.getMoney())
                .timestamp(Instant.now())
                .status(PaymentStatus.STARTED)
                .build();

        log.info(createLogEntry(payment));

        return payment;
    }


    public String createLogEntry(Payment payment){
        return String.format(LOG_FORMAT, payment.getMoney());
    }

}
