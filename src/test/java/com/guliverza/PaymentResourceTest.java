package com.guliverza;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PaymentResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/payment")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }

    @Test
    public void testValidPayment() {
        given()
                .body("{\"customerNum\":\"1111\",\"date\":\"2021-03-07\",\"senderName\":\"Name\",\"senderId\":\"persid\",\"senderAccountNo\":\"accountno\",\"benName\":\"ben name\",\"benId\":\"ben pers id\",\"benAccountNo\":\"ben account no\",\"benCountry\":\"country\",\"benBank\":\"bank\",\"benBankCode\":\"bankcode\",\"amount\":\"1000\",\"bankFee\":\"10\",\"amountStr\":\"one tausend\",\"paymentType\":\"\",\"rate\":\"1.0\",\"valueDate\":\"2021-03-07\",\"externalCode\":\"ext code\",\"details\":\"details\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/payment/create")
                .then()
                .statusCode(200)
                .body("success", is(true), "message", containsString("Payment successfully accepted for execution!"));
    }

    @Test
    public void testPaymentWithoutAmount() {
        given()
                .body("{\"customerNum\":\"1111\",\"date\":\"2021-03-07\",\"senderName\":\"Name\",\"senderId\":\"persid\",\"senderAccountNo\":\"accountno\",\"benName\":\"ben name\",\"benId\":\"ben pers id\",\"benAccountNo\":\"ben account no\",\"benCountry\":\"country\",\"benBank\":\"bank\",\"benBankCode\":\"bankcode\",\"bankFee\":\"10\",\"amountStr\":\"one tausend\",\"paymentType\":\"\",\"rate\":\"1.0\",\"valueDate\":\"2021-03-07\",\"externalCode\":\"ext code\",\"details\":\"details\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/payment/create")
                .then()
                .statusCode(200)
                .body("success", is(false), "message", containsString("Amount cannot be blank"));
    }

    @Test
    public void testPaymentWithNegativeAmount() {
        given()
                .body("{\"customerNum\":\"1111\",\"date\":\"2021-03-07\",\"senderName\":\"Name\",\"senderId\":\"persid\",\"senderAccountNo\":\"accountno\",\"benName\":\"ben name\",\"benId\":\"ben pers id\",\"benAccountNo\":\"ben account no\",\"benCountry\":\"country\",\"benBank\":\"bank\",\"benBankCode\":\"bankcode\",\"amount\":\"-1000\",\"bankFee\":\"10\",\"amountStr\":\"one tausend\",\"paymentType\":\"\",\"rate\":\"1.0\",\"valueDate\":\"2021-03-07\",\"externalCode\":\"ext code\",\"details\":\"details\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/payment/create")
                .then()
                .statusCode(200)
                .body("success", is(false), "message", containsString("Amount should be at least 1 currency unit"));
    }

}
