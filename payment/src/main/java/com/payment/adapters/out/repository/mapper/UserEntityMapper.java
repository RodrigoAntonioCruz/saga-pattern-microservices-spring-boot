package com.payment.adapters.out.repository.mapper;


import com.payment.adapters.out.repository.mapper.entity.UserEntity;
import com.payment.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

}
