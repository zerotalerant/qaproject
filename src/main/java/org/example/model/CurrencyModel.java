package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CurrencyModel {
    private Long id;
    @NotEmpty
    private String charCode;

    @NotNull
    private Long nominal;

    @NotEmpty
    private String currencyName;

    @NotNull
    private Double value;
}
