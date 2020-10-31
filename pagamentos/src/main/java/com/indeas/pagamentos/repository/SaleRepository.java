package com.indeas.pagamentos.repository;

import com.indeas.pagamentos.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {
}
