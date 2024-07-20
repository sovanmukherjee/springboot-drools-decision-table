package org.drools.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.drools.example.api.SalesOrderApi;
import org.drools.example.api.model.DiscountResponse;
import org.drools.example.api.model.State;
import org.drools.example.service.SalesOrderDiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;


@RestController
@RequiredArgsConstructor
public class SalesOrderController implements SalesOrderApi {
    private final SalesOrderDiscountService salesOrderDiscountService;


    @Override
    public ResponseEntity<DiscountResponse> getDiscount(State state, BigDecimal totalPurchaseAmount) {
        return ResponseEntity.ok().body(salesOrderDiscountService.getDiscount(state,totalPurchaseAmount));
    }
}