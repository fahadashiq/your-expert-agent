package com.hsrw.yea.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchCriteriaMapperTest {

    private SearchCriteriaMapper searchCriteriaMapper;

    @BeforeEach
    public void setUp() {
        searchCriteriaMapper = new SearchCriteriaMapperImpl();
    }
}
