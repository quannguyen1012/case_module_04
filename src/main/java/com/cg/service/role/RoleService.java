package com.cg.service.role;

import com.cg.model.dto.RoleDto;
import com.cg.model.dto.UserDto;
import com.cg.model.entity.Role;
import com.cg.model.entity.User;
import com.cg.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService{
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public RoleDto findOne(Long id) {
        Role role = roleRepository.findById(id).get();
        return modelMapper.map(role, RoleDto.class);
    }

    @Override
    public void save(RoleDto roleDto) {

    }

    @Override
    public void remove(Long id) {

    }
}

