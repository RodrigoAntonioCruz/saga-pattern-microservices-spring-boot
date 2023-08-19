package com.payment.application.ports.out;


import com.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);

}
