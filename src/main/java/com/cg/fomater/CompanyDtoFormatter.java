package com.cg.fomater;

import com.cg.model.dto.CompanyDto;
import com.cg.service.company.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CompanyDtoFormatter implements Formatter<CompanyDto> {

    private ICompanyService companyService;

    @Autowired
    public CompanyDtoFormatter(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public CompanyDto parse(String text, Locale locale) throws ParseException {
        CompanyDto companyDto = companyService.findOne(Long.parseLong(text));
        return companyDto;
    }

    @Override
    public String print(CompanyDto object, Locale locale) {
        return "[" + object.getId() + ", " +object.getCompany() + "]";
    }
}
