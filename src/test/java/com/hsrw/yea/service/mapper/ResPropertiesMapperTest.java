package com.hsrw.yea.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResPropertiesMapperTest {

    private ResPropertiesMapper resPropertiesMapper;

    @BeforeEach
    public void setUp() {
        resPropertiesMapper = new ResPropertiesMapperImpl();
    }
}
