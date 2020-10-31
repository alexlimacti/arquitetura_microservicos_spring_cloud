package com.indeas.pagamentos.service;

import com.indeas.pagamentos.converter.PaymentsConverter;
import com.indeas.pagamentos.data.vo.SaleVO;
import com.indeas.pagamentos.entity.ProductSale;
import com.indeas.pagamentos.entity.Sale;
import com.indeas.pagamentos.exception.ResourceNotFoundException;
import com.indeas.pagamentos.repository.ProductSaleRepository;
import com.indeas.pagamentos.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductSaleRepository productSaleRepository;

    public SaleVO create(SaleVO saleVO){
        Sale sale = saleRepository.save(PaymentsConverter.createSale(saleVO));
        List<ProductSale> productsSave = new ArrayList<>();
        saleVO.getProducts().forEach(p -> {
            ProductSale ps = PaymentsConverter.createProductSale(p);
            ps.setSale(sale);
            productSaleRepository.save(ps);
        });
        sale.setProducts(productsSave);
        return PaymentsConverter.createSaleVO(sale);
    }

    public Page<SaleVO> findAll(Pageable pageable) {
        var page = saleRepository.findAll(pageable);
        return page.map(this::convertToSaleVO);
    }

    public SaleVO findById(UUID id) {
        var entity = saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return PaymentsConverter.createSaleVO(entity);
    }

    private SaleVO convertToSaleVO(Sale sale) {
        return PaymentsConverter.createSaleVO(sale);
    }
}
