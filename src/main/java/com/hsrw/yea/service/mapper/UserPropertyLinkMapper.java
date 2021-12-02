package com.hsrw.yea.service.mapper;

import com.hsrw.yea.domain.*;
import com.hsrw.yea.service.dto.UserPropertyLinkDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserPropertyLink} and its DTO {@link UserPropertyLinkDTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class, ResPropertiesMapper.class })
public interface UserPropertyLinkMapper extends EntityMapper<UserPropertyLinkDTO, UserPropertyLink> {
    @Mapping(target = "user", source = "user", qualifiedByName = "id")
    @Mapping(target = "resProperties", source = "resProperties", qualifiedByName = "id")
    UserPropertyLinkDTO toDto(UserPropertyLink s);
}
