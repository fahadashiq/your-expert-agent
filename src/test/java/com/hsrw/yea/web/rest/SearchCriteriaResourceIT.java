package com.hsrw.yea.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.hsrw.yea.IntegrationTest;
import com.hsrw.yea.domain.SearchCriteria;
import com.hsrw.yea.repository.SearchCriteriaRepository;
import com.hsrw.yea.service.dto.SearchCriteriaDTO;
import com.hsrw.yea.service.mapper.SearchCriteriaMapper;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link SearchCriteriaResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SearchCriteriaResourceIT {

    private static final String DEFAULT_CRITERA = "AAAAAAAAAA";
    private static final String UPDATED_CRITERA = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/search-criteria";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SearchCriteriaRepository searchCriteriaRepository;

    @Autowired
    private SearchCriteriaMapper searchCriteriaMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSearchCriteriaMockMvc;

    private SearchCriteria searchCriteria;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SearchCriteria createEntity(EntityManager em) {
        SearchCriteria searchCriteria = new SearchCriteria().critera(DEFAULT_CRITERA);
        return searchCriteria;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SearchCriteria createUpdatedEntity(EntityManager em) {
        SearchCriteria searchCriteria = new SearchCriteria().critera(UPDATED_CRITERA);
        return searchCriteria;
    }

    @BeforeEach
    public void initTest() {
        searchCriteria = createEntity(em);
    }

    @Test
    @Transactional
    void createSearchCriteria() throws Exception {
        int databaseSizeBeforeCreate = searchCriteriaRepository.findAll().size();
        // Create the SearchCriteria
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(searchCriteria);
        restSearchCriteriaMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isCreated());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeCreate + 1);
        SearchCriteria testSearchCriteria = searchCriteriaList.get(searchCriteriaList.size() - 1);
        assertThat(testSearchCriteria.getCritera()).isEqualTo(DEFAULT_CRITERA);
    }

    @Test
    @Transactional
    void createSearchCriteriaWithExistingId() throws Exception {
        // Create the SearchCriteria with an existing ID
        searchCriteria.setId(1L);
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(searchCriteria);

        int databaseSizeBeforeCreate = searchCriteriaRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSearchCriteriaMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllSearchCriteria() throws Exception {
        // Initialize the database
        searchCriteriaRepository.saveAndFlush(searchCriteria);

        // Get all the searchCriteriaList
        restSearchCriteriaMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(searchCriteria.getId().intValue())))
            .andExpect(jsonPath("$.[*].critera").value(hasItem(DEFAULT_CRITERA)));
    }

    @Test
    @Transactional
    void getSearchCriteria() throws Exception {
        // Initialize the database
        searchCriteriaRepository.saveAndFlush(searchCriteria);

        // Get the searchCriteria
        restSearchCriteriaMockMvc
            .perform(get(ENTITY_API_URL_ID, searchCriteria.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(searchCriteria.getId().intValue()))
            .andExpect(jsonPath("$.critera").value(DEFAULT_CRITERA));
    }

    @Test
    @Transactional
    void getNonExistingSearchCriteria() throws Exception {
        // Get the searchCriteria
        restSearchCriteriaMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewSearchCriteria() throws Exception {
        // Initialize the database
        searchCriteriaRepository.saveAndFlush(searchCriteria);

        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();

        // Update the searchCriteria
        SearchCriteria updatedSearchCriteria = searchCriteriaRepository.findById(searchCriteria.getId()).get();
        // Disconnect from session so that the updates on updatedSearchCriteria are not directly saved in db
        em.detach(updatedSearchCriteria);
        updatedSearchCriteria.critera(UPDATED_CRITERA);
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(updatedSearchCriteria);

        restSearchCriteriaMockMvc
            .perform(
                put(ENTITY_API_URL_ID, searchCriteriaDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isOk());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
        SearchCriteria testSearchCriteria = searchCriteriaList.get(searchCriteriaList.size() - 1);
        assertThat(testSearchCriteria.getCritera()).isEqualTo(UPDATED_CRITERA);
    }

    @Test
    @Transactional
    void putNonExistingSearchCriteria() throws Exception {
        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();
        searchCriteria.setId(count.incrementAndGet());

        // Create the SearchCriteria
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(searchCriteria);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSearchCriteriaMockMvc
            .perform(
                put(ENTITY_API_URL_ID, searchCriteriaDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSearchCriteria() throws Exception {
        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();
        searchCriteria.setId(count.incrementAndGet());

        // Create the SearchCriteria
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(searchCriteria);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSearchCriteriaMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSearchCriteria() throws Exception {
        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();
        searchCriteria.setId(count.incrementAndGet());

        // Create the SearchCriteria
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(searchCriteria);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSearchCriteriaMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSearchCriteriaWithPatch() throws Exception {
        // Initialize the database
        searchCriteriaRepository.saveAndFlush(searchCriteria);

        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();

        // Update the searchCriteria using partial update
        SearchCriteria partialUpdatedSearchCriteria = new SearchCriteria();
        partialUpdatedSearchCriteria.setId(searchCriteria.getId());

        restSearchCriteriaMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSearchCriteria.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSearchCriteria))
            )
            .andExpect(status().isOk());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
        SearchCriteria testSearchCriteria = searchCriteriaList.get(searchCriteriaList.size() - 1);
        assertThat(testSearchCriteria.getCritera()).isEqualTo(DEFAULT_CRITERA);
    }

    @Test
    @Transactional
    void fullUpdateSearchCriteriaWithPatch() throws Exception {
        // Initialize the database
        searchCriteriaRepository.saveAndFlush(searchCriteria);

        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();

        // Update the searchCriteria using partial update
        SearchCriteria partialUpdatedSearchCriteria = new SearchCriteria();
        partialUpdatedSearchCriteria.setId(searchCriteria.getId());

        partialUpdatedSearchCriteria.critera(UPDATED_CRITERA);

        restSearchCriteriaMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSearchCriteria.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSearchCriteria))
            )
            .andExpect(status().isOk());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
        SearchCriteria testSearchCriteria = searchCriteriaList.get(searchCriteriaList.size() - 1);
        assertThat(testSearchCriteria.getCritera()).isEqualTo(UPDATED_CRITERA);
    }

    @Test
    @Transactional
    void patchNonExistingSearchCriteria() throws Exception {
        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();
        searchCriteria.setId(count.incrementAndGet());

        // Create the SearchCriteria
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(searchCriteria);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSearchCriteriaMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, searchCriteriaDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSearchCriteria() throws Exception {
        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();
        searchCriteria.setId(count.incrementAndGet());

        // Create the SearchCriteria
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(searchCriteria);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSearchCriteriaMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSearchCriteria() throws Exception {
        int databaseSizeBeforeUpdate = searchCriteriaRepository.findAll().size();
        searchCriteria.setId(count.incrementAndGet());

        // Create the SearchCriteria
        SearchCriteriaDTO searchCriteriaDTO = searchCriteriaMapper.toDto(searchCriteria);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSearchCriteriaMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(searchCriteriaDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the SearchCriteria in the database
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSearchCriteria() throws Exception {
        // Initialize the database
        searchCriteriaRepository.saveAndFlush(searchCriteria);

        int databaseSizeBeforeDelete = searchCriteriaRepository.findAll().size();

        // Delete the searchCriteria
        restSearchCriteriaMockMvc
            .perform(delete(ENTITY_API_URL_ID, searchCriteria.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SearchCriteria> searchCriteriaList = searchCriteriaRepository.findAll();
        assertThat(searchCriteriaList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
