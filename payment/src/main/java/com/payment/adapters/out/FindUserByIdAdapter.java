package com.payment.adapters.out;


import com.payment.adapters.out.repository.UserRepository;
import com.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.payment.application.core.domain.User;
import com.payment.application.ports.out.FindUserByIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(String userId) {
        var userEntity = userRepository.findById(userId);
        return userEntity.map(userEntityMapper::toUser);
    }
}
