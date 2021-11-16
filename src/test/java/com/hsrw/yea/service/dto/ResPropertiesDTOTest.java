package com.hsrw.yea.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.hsrw.yea.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ResPropertiesDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ResPropertiesDTO.class);
        ResPropertiesDTO resPropertiesDTO1 = new ResPropertiesDTO();
        resPropertiesDTO1.setId(1L);
        ResPropertiesDTO resPropertiesDTO2 = new ResPropertiesDTO();
        assertThat(resPropertiesDTO1).isNotEqualTo(resPropertiesDTO2);
        resPropertiesDTO2.setId(resPropertiesDTO1.getId());
        assertThat(resPropertiesDTO1).isEqualTo(resPropertiesDTO2);
        resPropertiesDTO2.setId(2L);
        assertThat(resPropertiesDTO1).isNotEqualTo(resPropertiesDTO2);
        resPropertiesDTO1.setId(null);
        assertThat(resPropertiesDTO1).isNotEqualTo(resPropertiesDTO2);
    }
}
