package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyEntity extends com.example.currency.entity.BaseEntity {

    @Column(name = "currency_name", nullable = false, unique = true)
    private String currencyName;

    @Column(name = "currency_char", nullable = false, unique = true)
    private String currencyChar;

    @Column(name = "nominal", nullable = false)
    private Long nominal;

    @Column(name = "currency_value", nullable = false)
    private Double currencyValue;
}
