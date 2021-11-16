package com.hsrw.yea.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.hsrw.yea.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ResPropertiesTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ResProperties.class);
        ResProperties resProperties1 = new ResProperties();
        resProperties1.setId(1L);
        ResProperties resProperties2 = new ResProperties();
        resProperties2.setId(resProperties1.getId());
        assertThat(resProperties1).isEqualTo(resProperties2);
        resProperties2.setId(2L);
        assertThat(resProperties1).isNotEqualTo(resProperties2);
        resProperties1.setId(null);
        assertThat(resProperties1).isNotEqualTo(resProperties2);
    }
}
