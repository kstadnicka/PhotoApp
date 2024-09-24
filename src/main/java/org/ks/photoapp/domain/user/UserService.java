package org.ks.photoapp.domain.user;

import org.ks.photoapp.domain.user.dto.UserDto;
import org.ks.photoapp.domain.user.dto.UserRegistrationDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UserDto> findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserDtoMapper::map);
    }

    @Transactional
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        userRepository.save(user);
    }
}
