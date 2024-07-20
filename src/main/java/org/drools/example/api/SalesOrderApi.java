package org.drools.example.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.drools.example.api.model.DiscountResponse;
import org.drools.example.api.model.State;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@OpenAPIDefinition(info = @Info(
        title = "Sales Order API",
        version = "1.0.0",
        description = "Sales Order Service",
        contact = @Contact(
                name = "Sovan Mukherjee",
                email = "sovanxxxxx@gmail.com")
))

@RequestMapping(value = "sales", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
public interface SalesOrderApi {

    @Operation(summary = "Get Maximum Discount")
    @GetMapping("/discount")
    ResponseEntity<DiscountResponse> getDiscount(@Parameter(description = "States") @RequestParam("state") State state,
                                                 @Parameter(description = "Total Purchase Amount") @RequestParam(value = "totalPurchaseAmount") BigDecimal totalPurchaseAmount);
}
