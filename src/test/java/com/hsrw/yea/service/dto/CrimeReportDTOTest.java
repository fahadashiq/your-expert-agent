package com.hsrw.yea.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.hsrw.yea.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CrimeReportDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CrimeReportDTO.class);
        CrimeReportDTO crimeReportDTO1 = new CrimeReportDTO();
        crimeReportDTO1.setId(1L);
        CrimeReportDTO crimeReportDTO2 = new CrimeReportDTO();
        assertThat(crimeReportDTO1).isNotEqualTo(crimeReportDTO2);
        crimeReportDTO2.setId(crimeReportDTO1.getId());
        assertThat(crimeReportDTO1).isEqualTo(crimeReportDTO2);
        crimeReportDTO2.setId(2L);
        assertThat(crimeReportDTO1).isNotEqualTo(crimeReportDTO2);
        crimeReportDTO1.setId(null);
        assertThat(crimeReportDTO1).isNotEqualTo(crimeReportDTO2);
    }
}
