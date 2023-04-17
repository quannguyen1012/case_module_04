package com.cg.fomater;

import com.cg.model.dto.RoleDto;
import com.cg.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class RoleDtoFormatter implements Formatter<RoleDto> {
    private IRoleService roleService;

    @Autowired
    public RoleDtoFormatter(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDto parse(String text, Locale locale) throws ParseException {
        RoleDto roleDto = roleService.findOne(Long.parseLong(text));
        return roleDto;
    }

    @Override
    public String print(RoleDto object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
