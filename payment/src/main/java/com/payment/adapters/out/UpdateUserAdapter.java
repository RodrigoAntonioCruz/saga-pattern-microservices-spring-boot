package com.payment.adapters.out;


import com.payment.adapters.out.repository.UserRepository;
import com.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.payment.application.core.domain.User;
import com.payment.application.ports.out.UpdateUserOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    @Override
    public void update(User user) {
        var userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }
}
