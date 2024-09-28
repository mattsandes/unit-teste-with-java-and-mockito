package br.com.sandes.mockito.constructor;

import java.math.BigDecimal;

public class PaymentProcessor {

    private boolean allowForeignCurrencies;
    private String fallbackOption;
    private BigDecimal taxRate;

    public PaymentProcessor(){
        this(false,
                "DEBIT",
                new BigDecimal("19.00"));
    }

    public PaymentProcessor(String falbackOption, BigDecimal taxRate){
        this(false,
                falbackOption,
                taxRate);
    }

    public PaymentProcessor(boolean allowForeignCurrencies, String falbackOption, BigDecimal taxRate) {
        this.allowForeignCurrencies = allowForeignCurrencies;
        this.fallbackOption = falbackOption;
        this.taxRate = taxRate;
    }

    public BigDecimal chargeCustomer(String customerId, BigDecimal netPrice) {
        System.out.println("About to charge customer: " + customerId);

        return BigDecimal.ZERO;
    }
}
