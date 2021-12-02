package com.hsrw.yea.service.mapper;

import com.hsrw.yea.domain.*;
import com.hsrw.yea.service.dto.UserInfoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserInfo} and its DTO {@link UserInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface UserInfoMapper extends EntityMapper<UserInfoDTO, UserInfo> {
    @Mapping(target = "user", source = "user", qualifiedByName = "id")
    UserInfoDTO toDto(UserInfo s);
}
