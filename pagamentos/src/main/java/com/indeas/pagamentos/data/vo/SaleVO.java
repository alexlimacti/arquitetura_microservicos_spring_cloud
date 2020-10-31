package com.indeas.pagamentos.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@JsonPropertyOrder({ "id", "data", "produtos", "valorTotal" })
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
}
