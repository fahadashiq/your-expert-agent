package com.hsrw.yea.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserPropertyLinkMapperTest {

    private UserPropertyLinkMapper userPropertyLinkMapper;

    @BeforeEach
    public void setUp() {
        userPropertyLinkMapper = new UserPropertyLinkMapperImpl();
    }
}
