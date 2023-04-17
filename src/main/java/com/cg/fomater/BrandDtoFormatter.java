package com.cg.fomater;

import com.cg.model.dto.BrandDto;
import com.cg.service.brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class BrandDtoFormatter implements Formatter<BrandDto> {

    private IBrandService brandService;

    @Autowired
    public BrandDtoFormatter(IBrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public BrandDto parse(String text, Locale locale) throws ParseException {
        BrandDto brandDto = brandService.findOne(Long.parseLong(text));
        return brandDto;
    }

    @Override
    public String print(BrandDto object, Locale locale) {
        return "[" + object.getId() + ", " +object.getBrand() + "]";
    }
}
