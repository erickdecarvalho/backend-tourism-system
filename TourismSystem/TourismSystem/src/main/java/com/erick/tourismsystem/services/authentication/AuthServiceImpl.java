package com.erick.tourismsystem.services.authentication;

import com.erick.tourismsystem.dto.SignupRequestDTO;
import com.erick.tourismsystem.dto.UserDto;
import com.erick.tourismsystem.entity.User;
import com.erick.tourismsystem.enums.UserRole;
import com.erick.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto signupClient(SignupRequestDTO signupRequestDTO) {
        User user = new User();

        user.setName(signupRequestDTO.name());
        user.setLastname(signupRequestDTO.lastname());
        user.setEmail(signupRequestDTO.email());
        user.setPassword(signupRequestDTO.phone());
        user.setPassword(signupRequestDTO.password());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }
}
