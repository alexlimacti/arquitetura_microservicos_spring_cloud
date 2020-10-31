package com.indeas.pagamentos.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@JsonPropertyOrder({"id", "date", "products", "amount"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductSaleVO extends RepresentationModel<ProductSaleVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("id_product")
    private Long idProduto;

    @JsonProperty("quantity")
    private Integer quantity;
}
