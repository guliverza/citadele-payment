package com.guliverza;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    @NotBlank(message = "Cust. num cannot be blank")
    public String customerNum;

    @FutureOrPresent(message = "Date cannot be blank and should not be in past")
    public LocalDate date;

    @NotBlank(message = "Sender's Name/Company cannot be blank")
    public String senderName;

    @NotBlank(message = "Registration No cannot be blank")
    public String senderId;

    @NotBlank(message = "Account No cannot be blank")
    public String senderAccountNo;

    @NotBlank(message = "Beneficiary Name/Company cannot be blank")
    public String benName;

    @NotBlank(message = "Beneficiary Registration No cannot be blank")
    public String benId;

    @NotBlank(message = "Beneficiary Account No cannot be blank")
    public String benAccountNo;

    @NotBlank(message = "Beneficiary country cannot be blank")
    public String benCountry;

    @NotBlank(message = "Beneficiary bank cannot be blank")
    public String benBank;

    @NotBlank(message = "Beneficiary bank code cannot be blank")
    public String benBankCode;

    @DecimalMin(message = "Amount should be at least 1 currency unit", value = "1.0")
    @NotNull(message = "Amount cannot be blank")
    public BigDecimal amount;

    @DecimalMin(message = "Bank commission cannot be negative", value = "0")
    public BigDecimal bankFee;

    @NotBlank(message = "Amount in words cannot be blank")
    public String amountStr;

    public String paymentType;

    @DecimalMin(message = "Exchange rate cannot be blank", value = "0.001")
    public BigDecimal rate;

    @FutureOrPresent(message = "Value date cannot be blank and should not be in past")
    public LocalDate valueDate;

    @NotBlank(message = "Code of external payment cannot be blank")
    public String externalCode;

    @NotBlank(message = "Payment details cannot be blank")
    public String details;

    @Override
    public String toString() {
        return "Payment{" +
                "customerNum='" + customerNum + '\'' +
                ", date=" + date +
                ", senderName='" + senderName + '\'' +
                ", senderId='" + senderId + '\'' +
                ", senderAccountNo='" + senderAccountNo + '\'' +
                ", benName='" + benName + '\'' +
                ", benId='" + benId + '\'' +
                ", benAccountNo='" + benAccountNo + '\'' +
                ", benCountry='" + benCountry + '\'' +
                ", benBank='" + benBank + '\'' +
                ", benBankCode='" + benBankCode + '\'' +
                ", amount=" + amount +
                ", bankFee=" + bankFee +
                ", amountStr='" + amountStr + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", rate=" + rate +
                ", valueDate=" + valueDate +
                ", externalCode='" + externalCode + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
