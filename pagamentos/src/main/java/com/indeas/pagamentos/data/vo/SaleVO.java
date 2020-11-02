package com.indeas.pagamentos.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.indeas.pagamentos.entity.Sale;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({ "id", "date", "products", "amount" })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SaleVO extends RepresentationModel<SaleVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("products")
    private List<ProductSaleVO> products;

    @JsonProperty("amount")
    private Double amount;

    public static SaleVO create(Sale sale) {
        return new ModelMapper().map(sale, SaleVO.class);
    }
}
