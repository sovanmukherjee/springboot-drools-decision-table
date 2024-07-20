package org.drools.example.service;

import org.drools.example.api.model.DiscountResponse;
import org.drools.example.api.model.State;

import java.math.BigDecimal;

public interface SalesOrderDiscountService {
    DiscountResponse getDiscount(State state, BigDecimal totalPurchaseAmount);
}
