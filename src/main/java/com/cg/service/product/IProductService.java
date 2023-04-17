package com.cg.service.product;

import com.cg.model.dto.ProductDto;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<ProductDto> {
    List<ProductDto> findAllByNameContaining(String name);
    List<ProductDto> findAllByBrand(Long id);

    List<ProductDto> findAllByCategories(Long id);
    List<ProductDto> findAllByCompany(Long id);
}
