package com.cg.fomater;

import com.cg.model.dto.MadeInDto;
import com.cg.service.madeIn.IMadeInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MadeInDtoFormatter implements Formatter<MadeInDto> {

    private IMadeInService madeInService;

    @Autowired
    public MadeInDtoFormatter(IMadeInService madeInService) {
        this.madeInService = madeInService;
    }

    @Override
    public MadeInDto parse(String text, Locale locale) throws ParseException {
        MadeInDto madeInDto = madeInService.findOne(Long.parseLong(text));
        return madeInDto;
    }

    @Override
    public String print(MadeInDto object, Locale locale) {
        return "[" + object.getId() + ", " +object.getMadeIn() + "]";
    }
}
