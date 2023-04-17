package com.cg.service.User;

import com.cg.model.dto.UserDto;
import com.cg.model.entity.User;
import com.cg.service.IGeneralService;


public interface IUserService extends IGeneralService<UserDto> {
    UserDto findByUsername(String username);
}
