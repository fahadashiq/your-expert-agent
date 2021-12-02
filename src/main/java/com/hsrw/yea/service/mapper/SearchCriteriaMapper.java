package com.hsrw.yea.service.mapper;

import com.hsrw.yea.domain.*;
import com.hsrw.yea.service.dto.SearchCriteriaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SearchCriteria} and its DTO {@link SearchCriteriaDTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface SearchCriteriaMapper extends EntityMapper<SearchCriteriaDTO, SearchCriteria> {
    @Mapping(target = "user", source = "user", qualifiedByName = "id")
    SearchCriteriaDTO toDto(SearchCriteria s);
}
