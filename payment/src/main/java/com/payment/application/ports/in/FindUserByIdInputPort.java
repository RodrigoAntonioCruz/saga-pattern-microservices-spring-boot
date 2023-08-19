package com.payment.application.ports.in;


import com.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final String id);

}
