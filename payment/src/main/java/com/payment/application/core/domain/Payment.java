package com.payment.application.core.domain;

import java.math.BigDecimal;

public class Payment {

    public Payment() {

    }

    public Payment(String id, String userId, String saleId, BigDecimal value) {
        this.id = id;
        this.userId = userId;
        this.saleId = saleId;
        this.value = value;
    }

    private String id;

    private String userId;

    private String saleId;

    private BigDecimal value;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
