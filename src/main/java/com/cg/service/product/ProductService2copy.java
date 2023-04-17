//package com.cg.service.product;
//
//import com.cg.model.dto.BrandDto;
//import com.cg.model.dto.CompanyDto;
//import com.cg.model.dto.MadeInDto;
//import com.cg.model.dto.ProductDto;
//import com.cg.model.entity.Product;
//import com.cg.repository.ProductRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ProductService2copy implements IProductService{
//    private final ProductRepository productRepository;
//
//    private final ModelMapper modelMapper;
//
//    public ProductService2copy(ProductRepository productRepository, ModelMapper modelMapper) {
//        this.productRepository = productRepository;
//        this.modelMapper = modelMapper;
//    }
//
//
////    @Override
////    public List<ProductDto> findAll() {
////        List<Product> products = productRepository.findAll();
////            return products.stream()
////                .map(product -> modelMapper.map(product, ProductDto.class))
////                .collect(Collectors.toList());
////    }
////    @Override
////    public List<ProductDto> findAll() {
////        List<Product> products = productRepository.findAll();
////        return getProductDtos(products);
////    }
//
////    @Override
////    public List<ProductDto> findAll() {
////        List<Product> products = productRepository.findAll();
////        return getProductDtos(products);
////    }
//
//    @Override
//    public List<ProductDto> findAll() {
//        List<Product> products = productRepository.findAll();
//        return products.parallelStream()
//                .map(product -> modelMapper.map(product , ProductDto.class)).collect(Collectors.toList());
//    }
//
//    @Override
//    public ProductDto findOne(Long id) {
//        Product product = productRepository.findById(id).get();
//        ProductDto productDto = modelMapper.map(product, ProductDto.class);
//        MadeInDto madeInDto = modelMapper.map(product.getMadeIn(), MadeInDto.class);
//        CompanyDto companyDto = modelMapper.map(product.getCompany(), CompanyDto.class);
//        BrandDto brandDto = modelMapper.map(product.getBrand(), BrandDto.class);
//        productDto.setBrandDto(brandDto);
//        productDto.setMadeInDto(madeInDto);
//        productDto.setCompanyDto(companyDto);
//        return productDto;
//    }
//
//    @Override
//    public void save(ProductDto productDto) {
//        Product pro = modelMapper.map(productDto, Product.class);
//        productRepository.save(pro);
//    }
//
//    @Override
//    public void remove(Long id) {
//        productRepository.deleteById(id);
//    }
//
//    @Override
//    public List<ProductDto> findAllByNameContaining(String name) {
//        List<Product> products = productRepository.findAllByNameContaining(name);
//        return getProductDtos(products);
//    }
//    @Override
//    public List<ProductDto> findAllByBrand(Long id){
//        List<Product> products = productRepository.findAllByBrandId(id);
//        return getProductDtos(products);
//    }
//
//    @Override
//    public List<ProductDto> findAllByCategories(Long id){
//        List<Product> products = productRepository.findAllByCategories(id);
//        return getProductDtos(products);
//    }
//
//    private List<ProductDto> getProductDtos(List<Product> products) {
//        List<ProductDto> productDtoCategory = products.stream()
//                .map(product -> {
//                    ProductDto productDto = modelMapper.map(product, ProductDto.class);
//                    MadeInDto madeInDto = modelMapper.map(product.getMadeIn(), MadeInDto.class);
//                    CompanyDto companyDto = modelMapper.map(product.getCompany(), CompanyDto.class);
//                    BrandDto brandDto = modelMapper.map(product.getBrand(), BrandDto.class);
//                    productDto.setBrandDto(brandDto);
//                    productDto.setMadeInDto(madeInDto);
//                    productDto.setCompanyDto(companyDto);
//                    return productDto;
//                }).collect(Collectors.toList());
//        return productDtoCategory;
//    }
//
//    @Override
//    public List<ProductDto> findAllByCompany(Long id) {
//        List<Product> products = productRepository.findAllByCompanyId(id);
//        return getProductDtos(products);
//    }
//
//
//}
