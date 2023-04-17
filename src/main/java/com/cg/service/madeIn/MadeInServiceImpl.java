package com.cg.service.madeIn;

import com.cg.model.dto.MadeInDto;
import com.cg.model.entity.MadeIn;
import com.cg.repository.MadeInRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MadeInServiceImpl implements IMadeInService {
    private final MadeInRepository madeInRepository;

    private final ModelMapper modelMapper;

    public MadeInServiceImpl(MadeInRepository madeInRepository, ModelMapper modelMapper) {
        this.madeInRepository = madeInRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MadeInDto> findAll() {
        List<MadeIn> madeIns = madeInRepository.findAll();
        return madeIns.stream()
                .map(madeIn -> modelMapper.map(madeIn, MadeInDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MadeInDto findOne(Long id) {
        MadeIn madeIn = madeInRepository.findById(id).get();
        return modelMapper.map(madeIn, MadeInDto.class);
    }

    @Override
    public void save(MadeInDto madeInDto) {
        MadeIn madeIn = modelMapper.map(madeInDto, MadeIn.class);
        madeInRepository.save(madeIn);
    }

    @Override
    public void remove(Long id) {
        madeInRepository.deleteById(id);
    }
}
