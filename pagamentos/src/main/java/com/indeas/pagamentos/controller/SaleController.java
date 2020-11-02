package com.indeas.pagamentos.controller;

import com.indeas.pagamentos.data.vo.SaleVO;
import com.indeas.pagamentos.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private PagedResourcesAssembler<SaleVO> assembler;

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public SaleVO findById(@PathVariable("id") UUID id) {
        SaleVO saleVO = saleService.findById(id);
        saleVO.add(linkTo(methodOn(SaleController.class).findById(id)).withSelfRel());
        return saleVO;
    }

    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "limit", defaultValue = "12") int limit,
                                     @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "data"));

        Page<SaleVO> sales = saleService.findAll(pageable);
        sales.stream().forEach(p -> p.add(linkTo(methodOn(SaleController.class).findById(p.getId())).withSelfRel()));

        PagedModel<EntityModel<SaleVO>> pagedModel = assembler.toModel(sales);

        return new ResponseEntity<>(pagedModel, HttpStatus.OK);
    }

    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
            "application/json", "application/xml", "application/x-yaml" })
    public SaleVO create(@RequestBody SaleVO saleVO) {
        SaleVO savedSaleVo = saleService.create(saleVO);
        savedSaleVo.add(linkTo(methodOn(SaleController.class).findById(savedSaleVo.getId())).withSelfRel());
        return savedSaleVo;
    }
}
