package com.erick.tourismsystem.services.authentication;

import com.erick.tourismsystem.dto.SignupRequestDTO;
import com.erick.tourismsystem.dto.UserDto;

public interface AuthService {

    public UserDto signupClient(SignupRequestDTO signupRequestDTO);
}
