package com.inventory.adapters.out.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "inventories")
public class InventoryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4474121600274415892L;

    @Id
    private String id;

    private String productId;

    private Integer quantity;

}
