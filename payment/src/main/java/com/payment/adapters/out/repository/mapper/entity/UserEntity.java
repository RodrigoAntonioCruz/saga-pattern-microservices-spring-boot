package com.payment.adapters.out.repository.mapper.entity;


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
@Document(collection = "users")
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7116100726416912856L;

    @Id
    private String id;

    private String name;

    private BigDecimal balance;

}
