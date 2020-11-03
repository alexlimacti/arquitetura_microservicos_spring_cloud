package com.indeas.produto.service;

import com.indeas.produto.converter.ProductConverter;
import com.indeas.produto.data.vo.ProductVO;
import com.indeas.produto.entity.Product;
import com.indeas.produto.exception.ResourceNotFoundException;
import com.indeas.produto.message.ProdutoSendMessage;
import com.indeas.produto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProdutoSendMessage produtoSendMessage;

    public ProductVO create(ProductVO productVO) {
        ProductVO prodVoRetorno = ProductConverter.createProductVO(productRepository.save(ProductConverter.createProduct(productVO)));
        produtoSendMessage.sendMessage(prodVoRetorno);
        return prodVoRetorno;
    }

    public Page<ProductVO> findAll(Pageable pageable){
        var page = productRepository.findAll(pageable);
        return page.map(this::converteToProductVO);
    }

    private ProductVO converteToProductVO(Product product){
        return ProductConverter.createProductVO(product);
    }

    public ProductVO findById(UUID id){
        var entity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No founds records for ID"));
        return ProductConverter.createProductVO(entity);
    }

    public ProductVO update(ProductVO productVO){
        final Optional<Product> optionalProduct = productRepository.findById(productVO.getId());
        if(!optionalProduct.isPresent())
            new ResourceNotFoundException("No founds records for ID");
        return ProductConverter.createProductVO(productRepository.save(ProductConverter.createProduct(productVO)));
    }

    public void delete(UUID id){
        var entity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No founds records for ID"));
        productRepository.delete(entity);
    }
}
