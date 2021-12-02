package com.hsrw.yea.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrimeReportMapperTest {

    private CrimeReportMapper crimeReportMapper;

    @BeforeEach
    public void setUp() {
        crimeReportMapper = new CrimeReportMapperImpl();
    }
}
