package org.example.mapper;

import org.example.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper ( UserMapper.class );

    UserResponse toUserResponseDto ( UserEntity user );

    List<UserModel> toUsersModel ( List<UserEntity> users );

    UserAuthRequest toUserAuthDto ( UserEntity user );

    UserEntity toUserEntity ( UserResponse userResponse );
}
