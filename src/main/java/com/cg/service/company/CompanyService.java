package com.cg.service.company;


import com.cg.model.dto.CompanyDto;
import com.cg.model.entity.Company;
import com.cg.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService implements ICompanyService {
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    public CompanyService(ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyDto> findAll() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto findOne(Long id) {
        Company company = companyRepository.findById(id).get();
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public void save(CompanyDto companyDto) {
        Company company = modelMapper.map(companyDto, Company.class);
        companyRepository.save(company);
    }

    @Override
    public void remove(Long id) {
        companyRepository.deleteById(id);
    }
}
