package com.hsrw.yea.service.mapper;

import com.hsrw.yea.domain.*;
import com.hsrw.yea.service.dto.ResPropertiesDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ResProperties} and its DTO {@link ResPropertiesDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ResPropertiesMapper extends EntityMapper<ResPropertiesDTO, ResProperties> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ResPropertiesDTO toDtoId(ResProperties resProperties);
}
