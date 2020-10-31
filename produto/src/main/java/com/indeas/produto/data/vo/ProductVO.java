package com.indeas.produto.data.vo;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private float stock;
    private Double preco;
}
