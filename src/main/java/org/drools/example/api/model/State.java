package org.drools.example.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum State {
    ANDHRA_PRADESH("AP","Andhra Pradesh"),

    ARUNACHAL_PRADESH("AR","Arunachal Pradesh"),

    ASSAM("AS","Assam"),

    BIHAR("BR","Bihar"),

    JAMMU_AND_KASHMIR("JK","Jammu and Kashmir"),

    KARNATAKA("KA","Karnataka"),

    WEST_BENGAL("WB","West Bengal"),

    LAKSHADWEEP("LD","Lakshadweep"),

    OTHERS("OTHERS","Others, Not available in the list");

    private final String code;
    private final String name;
}
