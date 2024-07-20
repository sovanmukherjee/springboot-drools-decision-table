package org.drools.example.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountResponse {
    @Schema(description = "Total Purchase Amount")
    private BigDecimal totalPurchaseAmount;

    @Schema(description = "Specifies whether a discount is permitted.")
    private boolean discountAllowed;

    @Schema(description = "Rate of discount(as a percentage")
    private int discountRate;

    @Schema(description = "Amount to pay after discount has been applied.")
    private BigDecimal payableAmount;
}
