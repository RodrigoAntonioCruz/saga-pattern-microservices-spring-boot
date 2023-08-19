package com.sale.adapters.out.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sales")
public class SaleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3966033972384323190L;

    @Id
    private String id;

    private String productId;

    private String userId;

    private BigDecimal value;

    private Integer statusId;

    private Integer quantity;

}
