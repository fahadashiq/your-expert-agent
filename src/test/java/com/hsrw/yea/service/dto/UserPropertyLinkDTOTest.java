package com.hsrw.yea.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.hsrw.yea.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserPropertyLinkDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserPropertyLinkDTO.class);
        UserPropertyLinkDTO userPropertyLinkDTO1 = new UserPropertyLinkDTO();
        userPropertyLinkDTO1.setId(1L);
        UserPropertyLinkDTO userPropertyLinkDTO2 = new UserPropertyLinkDTO();
        assertThat(userPropertyLinkDTO1).isNotEqualTo(userPropertyLinkDTO2);
        userPropertyLinkDTO2.setId(userPropertyLinkDTO1.getId());
        assertThat(userPropertyLinkDTO1).isEqualTo(userPropertyLinkDTO2);
        userPropertyLinkDTO2.setId(2L);
        assertThat(userPropertyLinkDTO1).isNotEqualTo(userPropertyLinkDTO2);
        userPropertyLinkDTO1.setId(null);
        assertThat(userPropertyLinkDTO1).isNotEqualTo(userPropertyLinkDTO2);
    }
}
