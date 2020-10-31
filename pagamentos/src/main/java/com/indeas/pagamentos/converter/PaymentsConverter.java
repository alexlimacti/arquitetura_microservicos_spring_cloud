package com.indeas.pagamentos.converter;

import com.indeas.pagamentos.data.vo.ProductSaleVO;
import com.indeas.pagamentos.data.vo.ProductVO;
import com.indeas.pagamentos.data.vo.SaleVO;
import com.indeas.pagamentos.entity.Product;
import com.indeas.pagamentos.entity.ProductSale;
import com.indeas.pagamentos.entity.Sale;
import org.modelmapper.ModelMapper;

public class PaymentsConverter {

    public static ProductVO createProductVO (Product product){
        return new ModelMapper().map(product, ProductVO.class);
    }

    public static Product createProduct (ProductVO productVO){
        return new ModelMapper().map(productVO, Product.class);
    }

    public static SaleVO createSaleVO (Sale sale){
        return new ModelMapper().map(sale, SaleVO.class);
    }

    public static Sale createSale (SaleVO saleVO){
        return new ModelMapper().map(saleVO, Sale.class);
    }

    public static ProductSaleVO createProductSaleVO (ProductSale productSale){
        return new ModelMapper().map(productSale, ProductSaleVO.class);
    }

    public static ProductSale createProductSale (ProductSaleVO productSaleVO){
        return new ModelMapper().map(productSaleVO, ProductSale.class);
    }

}
