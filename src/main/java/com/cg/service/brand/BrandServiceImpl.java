package com.cg.service.brand;

import com.cg.model.dto.BrandDto;
import com.cg.model.entity.Brand;
import com.cg.repository.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements IBrandService{

    private final BrandRepository brandRepository;

    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandDto> findAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> modelMapper.map(brand, BrandDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BrandDto findOne(Long id) {
        Brand brand = brandRepository.findById(id).get();
        return modelMapper.map(brand, BrandDto.class);
    }

    @Override
    public void save(BrandDto brandDto) {
        Brand brand = modelMapper.map(brandDto, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void remove(Long id) {
        brandRepository.deleteById(id);
    }
}
