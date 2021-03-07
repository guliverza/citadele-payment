package com.guliverza;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;

@ApplicationScoped
public class PaymentService {
    private static final Logger log = Logger.getLogger(PaymentService.class);

    @Inject
    Mailer mailer;

    public void doPayment(@Valid Payment payment) {
        log.debug("Received valid payment, sending it to service@citadele.lv");
        log.info("AMOUNT " + payment.amount);
        mailer.send(Mail.withText("service@citadele.lv",
                "Payment received from " + payment.benName + " for " + payment.amount,
                payment.toString()));
    }
}
