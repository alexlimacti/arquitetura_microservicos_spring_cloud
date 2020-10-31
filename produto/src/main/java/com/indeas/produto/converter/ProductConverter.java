package com.indeas.produto.converter;

import com.indeas.produto.data.vo.ProductVO;
import com.indeas.produto.entity.Product;
import org.modelmapper.ModelMapper;

public class ProductConverter {

    public static ProductVO createProductVO (Product product){
        return new ModelMapper().map(product, ProductVO.class);
    }

    public static Product createProduct(ProductVO productVO){
        return new ModelMapper().map(productVO, Product.class);
    }

}
