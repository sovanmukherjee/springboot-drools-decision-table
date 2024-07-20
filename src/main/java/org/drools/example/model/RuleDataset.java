package org.drools.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuleDataset {
    private String stateCode;
    private BigDecimal totalPurchaseAmount;

    private boolean discountAllowed;
    private int discountRate;
    private BigDecimal payableAmount;



}
