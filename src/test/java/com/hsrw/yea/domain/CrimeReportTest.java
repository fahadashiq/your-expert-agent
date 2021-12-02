package com.hsrw.yea.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.hsrw.yea.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CrimeReportTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CrimeReport.class);
        CrimeReport crimeReport1 = new CrimeReport();
        crimeReport1.setId(1L);
        CrimeReport crimeReport2 = new CrimeReport();
        crimeReport2.setId(crimeReport1.getId());
        assertThat(crimeReport1).isEqualTo(crimeReport2);
        crimeReport2.setId(2L);
        assertThat(crimeReport1).isNotEqualTo(crimeReport2);
        crimeReport1.setId(null);
        assertThat(crimeReport1).isNotEqualTo(crimeReport2);
    }
}
