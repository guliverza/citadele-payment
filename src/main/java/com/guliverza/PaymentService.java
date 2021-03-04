package com.guliverza;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class PaymentService {

    public void validateBook(@Valid Payment payment) {
        // your business logic here
    }
}
