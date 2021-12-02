package com.hsrw.yea.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.hsrw.yea.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SearchCriteriaDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SearchCriteriaDTO.class);
        SearchCriteriaDTO searchCriteriaDTO1 = new SearchCriteriaDTO();
        searchCriteriaDTO1.setId(1L);
        SearchCriteriaDTO searchCriteriaDTO2 = new SearchCriteriaDTO();
        assertThat(searchCriteriaDTO1).isNotEqualTo(searchCriteriaDTO2);
        searchCriteriaDTO2.setId(searchCriteriaDTO1.getId());
        assertThat(searchCriteriaDTO1).isEqualTo(searchCriteriaDTO2);
        searchCriteriaDTO2.setId(2L);
        assertThat(searchCriteriaDTO1).isNotEqualTo(searchCriteriaDTO2);
        searchCriteriaDTO1.setId(null);
        assertThat(searchCriteriaDTO1).isNotEqualTo(searchCriteriaDTO2);
    }
}
