package com.guliverza;

import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/payment")
public class PaymentResource {

    @Inject
    Validator validator;

    @Inject
    PaymentService paymentService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result tryMeServiceMethodValidation(Payment payment) {
        try {
            paymentService.validateBook(payment);
            return new Result("Book is valid! It was validated by service method validation.");
        } catch (ConstraintViolationException e) {
            return new Result(e.getConstraintViolations());
        }
    }

    public static class Result {

        private String message;
        private boolean success;

        Result(String message) {
            this.success = true;
            this.message = message;
        }

        Result(Set<? extends ConstraintViolation<?>> violations) {
            this.success = false;
            this.message = violations.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
        }

        public String getMessage() {
            return message;
        }

        public boolean isSuccess() {
            return success;
        }

    }
}
