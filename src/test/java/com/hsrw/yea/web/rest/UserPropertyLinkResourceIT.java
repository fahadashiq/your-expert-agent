package com.hsrw.yea.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.hsrw.yea.IntegrationTest;
import com.hsrw.yea.domain.UserPropertyLink;
import com.hsrw.yea.repository.UserPropertyLinkRepository;
import com.hsrw.yea.service.dto.UserPropertyLinkDTO;
import com.hsrw.yea.service.mapper.UserPropertyLinkMapper;
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
 * Integration tests for the {@link UserPropertyLinkResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class UserPropertyLinkResourceIT {

    private static final Boolean DEFAULT_IS_FAVOURITE = false;
    private static final Boolean UPDATED_IS_FAVOURITE = true;

    private static final String ENTITY_API_URL = "/api/user-property-links";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private UserPropertyLinkRepository userPropertyLinkRepository;

    @Autowired
    private UserPropertyLinkMapper userPropertyLinkMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUserPropertyLinkMockMvc;

    private UserPropertyLink userPropertyLink;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserPropertyLink createEntity(EntityManager em) {
        UserPropertyLink userPropertyLink = new UserPropertyLink().isFavourite(DEFAULT_IS_FAVOURITE);
        return userPropertyLink;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserPropertyLink createUpdatedEntity(EntityManager em) {
        UserPropertyLink userPropertyLink = new UserPropertyLink().isFavourite(UPDATED_IS_FAVOURITE);
        return userPropertyLink;
    }

    @BeforeEach
    public void initTest() {
        userPropertyLink = createEntity(em);
    }

    @Test
    @Transactional
    void createUserPropertyLink() throws Exception {
        int databaseSizeBeforeCreate = userPropertyLinkRepository.findAll().size();
        // Create the UserPropertyLink
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(userPropertyLink);
        restUserPropertyLinkMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isCreated());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeCreate + 1);
        UserPropertyLink testUserPropertyLink = userPropertyLinkList.get(userPropertyLinkList.size() - 1);
        assertThat(testUserPropertyLink.getIsFavourite()).isEqualTo(DEFAULT_IS_FAVOURITE);
    }

    @Test
    @Transactional
    void createUserPropertyLinkWithExistingId() throws Exception {
        // Create the UserPropertyLink with an existing ID
        userPropertyLink.setId(1L);
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(userPropertyLink);

        int databaseSizeBeforeCreate = userPropertyLinkRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restUserPropertyLinkMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllUserPropertyLinks() throws Exception {
        // Initialize the database
        userPropertyLinkRepository.saveAndFlush(userPropertyLink);

        // Get all the userPropertyLinkList
        restUserPropertyLinkMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(userPropertyLink.getId().intValue())))
            .andExpect(jsonPath("$.[*].isFavourite").value(hasItem(DEFAULT_IS_FAVOURITE.booleanValue())));
    }

    @Test
    @Transactional
    void getUserPropertyLink() throws Exception {
        // Initialize the database
        userPropertyLinkRepository.saveAndFlush(userPropertyLink);

        // Get the userPropertyLink
        restUserPropertyLinkMockMvc
            .perform(get(ENTITY_API_URL_ID, userPropertyLink.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(userPropertyLink.getId().intValue()))
            .andExpect(jsonPath("$.isFavourite").value(DEFAULT_IS_FAVOURITE.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingUserPropertyLink() throws Exception {
        // Get the userPropertyLink
        restUserPropertyLinkMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewUserPropertyLink() throws Exception {
        // Initialize the database
        userPropertyLinkRepository.saveAndFlush(userPropertyLink);

        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();

        // Update the userPropertyLink
        UserPropertyLink updatedUserPropertyLink = userPropertyLinkRepository.findById(userPropertyLink.getId()).get();
        // Disconnect from session so that the updates on updatedUserPropertyLink are not directly saved in db
        em.detach(updatedUserPropertyLink);
        updatedUserPropertyLink.isFavourite(UPDATED_IS_FAVOURITE);
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(updatedUserPropertyLink);

        restUserPropertyLinkMockMvc
            .perform(
                put(ENTITY_API_URL_ID, userPropertyLinkDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isOk());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
        UserPropertyLink testUserPropertyLink = userPropertyLinkList.get(userPropertyLinkList.size() - 1);
        assertThat(testUserPropertyLink.getIsFavourite()).isEqualTo(UPDATED_IS_FAVOURITE);
    }

    @Test
    @Transactional
    void putNonExistingUserPropertyLink() throws Exception {
        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();
        userPropertyLink.setId(count.incrementAndGet());

        // Create the UserPropertyLink
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(userPropertyLink);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUserPropertyLinkMockMvc
            .perform(
                put(ENTITY_API_URL_ID, userPropertyLinkDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchUserPropertyLink() throws Exception {
        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();
        userPropertyLink.setId(count.incrementAndGet());

        // Create the UserPropertyLink
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(userPropertyLink);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUserPropertyLinkMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamUserPropertyLink() throws Exception {
        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();
        userPropertyLink.setId(count.incrementAndGet());

        // Create the UserPropertyLink
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(userPropertyLink);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUserPropertyLinkMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateUserPropertyLinkWithPatch() throws Exception {
        // Initialize the database
        userPropertyLinkRepository.saveAndFlush(userPropertyLink);

        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();

        // Update the userPropertyLink using partial update
        UserPropertyLink partialUpdatedUserPropertyLink = new UserPropertyLink();
        partialUpdatedUserPropertyLink.setId(userPropertyLink.getId());

        partialUpdatedUserPropertyLink.isFavourite(UPDATED_IS_FAVOURITE);

        restUserPropertyLinkMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedUserPropertyLink.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedUserPropertyLink))
            )
            .andExpect(status().isOk());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
        UserPropertyLink testUserPropertyLink = userPropertyLinkList.get(userPropertyLinkList.size() - 1);
        assertThat(testUserPropertyLink.getIsFavourite()).isEqualTo(UPDATED_IS_FAVOURITE);
    }

    @Test
    @Transactional
    void fullUpdateUserPropertyLinkWithPatch() throws Exception {
        // Initialize the database
        userPropertyLinkRepository.saveAndFlush(userPropertyLink);

        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();

        // Update the userPropertyLink using partial update
        UserPropertyLink partialUpdatedUserPropertyLink = new UserPropertyLink();
        partialUpdatedUserPropertyLink.setId(userPropertyLink.getId());

        partialUpdatedUserPropertyLink.isFavourite(UPDATED_IS_FAVOURITE);

        restUserPropertyLinkMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedUserPropertyLink.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedUserPropertyLink))
            )
            .andExpect(status().isOk());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
        UserPropertyLink testUserPropertyLink = userPropertyLinkList.get(userPropertyLinkList.size() - 1);
        assertThat(testUserPropertyLink.getIsFavourite()).isEqualTo(UPDATED_IS_FAVOURITE);
    }

    @Test
    @Transactional
    void patchNonExistingUserPropertyLink() throws Exception {
        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();
        userPropertyLink.setId(count.incrementAndGet());

        // Create the UserPropertyLink
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(userPropertyLink);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUserPropertyLinkMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, userPropertyLinkDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchUserPropertyLink() throws Exception {
        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();
        userPropertyLink.setId(count.incrementAndGet());

        // Create the UserPropertyLink
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(userPropertyLink);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUserPropertyLinkMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamUserPropertyLink() throws Exception {
        int databaseSizeBeforeUpdate = userPropertyLinkRepository.findAll().size();
        userPropertyLink.setId(count.incrementAndGet());

        // Create the UserPropertyLink
        UserPropertyLinkDTO userPropertyLinkDTO = userPropertyLinkMapper.toDto(userPropertyLink);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUserPropertyLinkMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(userPropertyLinkDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the UserPropertyLink in the database
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteUserPropertyLink() throws Exception {
        // Initialize the database
        userPropertyLinkRepository.saveAndFlush(userPropertyLink);

        int databaseSizeBeforeDelete = userPropertyLinkRepository.findAll().size();

        // Delete the userPropertyLink
        restUserPropertyLinkMockMvc
            .perform(delete(ENTITY_API_URL_ID, userPropertyLink.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<UserPropertyLink> userPropertyLinkList = userPropertyLinkRepository.findAll();
        assertThat(userPropertyLinkList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
