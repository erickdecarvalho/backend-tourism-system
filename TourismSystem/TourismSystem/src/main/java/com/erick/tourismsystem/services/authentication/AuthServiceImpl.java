package com.erick.tourismsystem.services.authentication;

import com.erick.tourismsystem.dto.SignupRequestDTO;
import com.erick.tourismsystem.dto.UserDto;
import com.erick.tourismsystem.entity.User;
import com.erick.tourismsystem.enums.UserRole;
import com.erick.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.password()));

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }

    @Override
    public Boolean presentByEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    public UserDto signupCompany(SignupRequestDTO signupRequestDTO) {
        User user = new User();

        user.setName(signupRequestDTO.name());
        user.setEmail(signupRequestDTO.email());
        user.setPassword(signupRequestDTO.phone());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.password()));

        user.setRole(UserRole.COMPANY);

        return userRepository.save(user).getDto();
    }
}
