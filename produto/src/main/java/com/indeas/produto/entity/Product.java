package com.indeas.produto.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name="name", nullable = false, length = 255)
    private String name;

    @Column(name="stock", nullable = false, length = 10)
    private float stock;

    @Column(name="stock", nullable = false, length = 10)
    private Double preco;

}
