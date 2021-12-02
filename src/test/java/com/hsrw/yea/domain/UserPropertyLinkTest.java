package com.hsrw.yea.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.hsrw.yea.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserPropertyLinkTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserPropertyLink.class);
        UserPropertyLink userPropertyLink1 = new UserPropertyLink();
        userPropertyLink1.setId(1L);
        UserPropertyLink userPropertyLink2 = new UserPropertyLink();
        userPropertyLink2.setId(userPropertyLink1.getId());
        assertThat(userPropertyLink1).isEqualTo(userPropertyLink2);
        userPropertyLink2.setId(2L);
        assertThat(userPropertyLink1).isNotEqualTo(userPropertyLink2);
        userPropertyLink1.setId(null);
        assertThat(userPropertyLink1).isNotEqualTo(userPropertyLink2);
    }
}
