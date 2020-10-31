package com.indeas.pagamentos.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@JsonPropertyOrder({ "id", "stock" })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductVO extends RepresentationModel<ProductVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("stock")
    private float stock;
}
