package com.indeas.pagamentos.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="sale")
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name = "data", nullable = false)
    private Date date;

    @Column(name = "amount", nullable = false, length = 10)
    private Double amount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.REFRESH)
    private List<ProductSale> products;

}
