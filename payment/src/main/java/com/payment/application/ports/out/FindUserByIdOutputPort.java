package com.payment.application.ports.out;


import com.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(String userId);

}
