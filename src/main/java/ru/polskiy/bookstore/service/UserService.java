package ru.polskiy.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.polskiy.bookstore.db.entity.User;
import ru.polskiy.bookstore.db.repository.UserRepository;
import ru.polskiy.bookstore.db.types.Role;
import ru.polskiy.bookstore.dto.UserCreateEditDto;
import ru.polskiy.bookstore.dto.UserReadDto;
import ru.polskiy.bookstore.mapper.UserCreateEditMapper;
import ru.polskiy.bookstore.mapper.UserReadMapper;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {
    private final UserCreateEditMapper userCreateEditMapper;
    private final UserReadMapper userReadMapper;
    private final UserRepository userRepository;
    public List<UserReadDto> findAll(){
        return userRepository.findAll().stream()
                .map(userReadMapper::toDto)
                .toList();
    }
    public Optional<UserReadDto> findById(Long id){
        return userRepository.findById(id)
                .map(userReadMapper::toDto);
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByLogin(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getLogin(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())
                )).orElseThrow(() -> new UsernameNotFoundException("failed to retrieve user:" + username));
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) { //TODO write test to check if UserReadDto Correct
        return Optional.of(userDto)
                .map(userCreateEditMapper::toEntity)
                .map(userRepository::save)
                .map(userReadMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userDto) {
        return userRepository.findById(id)
                .map(userToEdit->userCreateEditMapper.map(userDto, userToEdit))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::toDto);
    }

}
