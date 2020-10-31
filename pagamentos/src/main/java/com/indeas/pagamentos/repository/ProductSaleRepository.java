package com.indeas.pagamentos.repository;

import com.indeas.pagamentos.entity.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductSaleRepository extends JpaRepository<ProductSale, UUID> {
}
