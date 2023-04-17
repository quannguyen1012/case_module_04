package com.cg.service;

import com.cg.model.dto.UserDto;
import com.cg.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    T findOne(Long id);

    void save(T t);

    void remove(Long id);
}
