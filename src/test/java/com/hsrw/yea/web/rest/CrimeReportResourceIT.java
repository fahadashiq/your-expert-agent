package com.hsrw.yea.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.hsrw.yea.IntegrationTest;
import com.hsrw.yea.domain.CrimeReport;
import com.hsrw.yea.repository.CrimeReportRepository;
import com.hsrw.yea.service.dto.CrimeReportDTO;
import com.hsrw.yea.service.mapper.CrimeReportMapper;
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
 * Integration tests for the {@link CrimeReportResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CrimeReportResourceIT {

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final Integer DEFAULT_POPULATION = 1;
    private static final Integer UPDATED_POPULATION = 2;

    private static final Integer DEFAULT_MURDER = 1;
    private static final Integer UPDATED_MURDER = 2;

    private static final Integer DEFAULT_RAPE = 1;
    private static final Integer UPDATED_RAPE = 2;

    private static final Integer DEFAULT_ROBBERY = 1;
    private static final Integer UPDATED_ROBBERY = 2;

    private static final Integer DEFAULT_AGGRAVATED_ASSAULT = 1;
    private static final Integer UPDATED_AGGRAVATED_ASSAULT = 2;

    private static final Integer DEFAULT_PROPERTY_CRIME = 1;
    private static final Integer UPDATED_PROPERTY_CRIME = 2;

    private static final Integer DEFAULT_BURGLARY = 1;
    private static final Integer UPDATED_BURGLARY = 2;

    private static final Integer DEFAULT_LARCENY = 1;
    private static final Integer UPDATED_LARCENY = 2;

    private static final Integer DEFAULT_VEHICLE_THEFT = 1;
    private static final Integer UPDATED_VEHICLE_THEFT = 2;

    private static final Integer DEFAULT_ARSON = 1;
    private static final Integer UPDATED_ARSON = 2;

    private static final String ENTITY_API_URL = "/api/crime-reports";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private CrimeReportRepository crimeReportRepository;

    @Autowired
    private CrimeReportMapper crimeReportMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCrimeReportMockMvc;

    private CrimeReport crimeReport;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CrimeReport createEntity(EntityManager em) {
        CrimeReport crimeReport = new CrimeReport()
            .city(DEFAULT_CITY)
            .population(DEFAULT_POPULATION)
            .murder(DEFAULT_MURDER)
            .rape(DEFAULT_RAPE)
            .robbery(DEFAULT_ROBBERY)
            .aggravatedAssault(DEFAULT_AGGRAVATED_ASSAULT)
            .propertyCrime(DEFAULT_PROPERTY_CRIME)
            .burglary(DEFAULT_BURGLARY)
            .larceny(DEFAULT_LARCENY)
            .vehicleTheft(DEFAULT_VEHICLE_THEFT)
            .arson(DEFAULT_ARSON);
        return crimeReport;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CrimeReport createUpdatedEntity(EntityManager em) {
        CrimeReport crimeReport = new CrimeReport()
            .city(UPDATED_CITY)
            .population(UPDATED_POPULATION)
            .murder(UPDATED_MURDER)
            .rape(UPDATED_RAPE)
            .robbery(UPDATED_ROBBERY)
            .aggravatedAssault(UPDATED_AGGRAVATED_ASSAULT)
            .propertyCrime(UPDATED_PROPERTY_CRIME)
            .burglary(UPDATED_BURGLARY)
            .larceny(UPDATED_LARCENY)
            .vehicleTheft(UPDATED_VEHICLE_THEFT)
            .arson(UPDATED_ARSON);
        return crimeReport;
    }

    @BeforeEach
    public void initTest() {
        crimeReport = createEntity(em);
    }

    @Test
    @Transactional
    void createCrimeReport() throws Exception {
        int databaseSizeBeforeCreate = crimeReportRepository.findAll().size();
        // Create the CrimeReport
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(crimeReport);
        restCrimeReportMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(crimeReportDTO))
            )
            .andExpect(status().isCreated());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeCreate + 1);
        CrimeReport testCrimeReport = crimeReportList.get(crimeReportList.size() - 1);
        assertThat(testCrimeReport.getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(testCrimeReport.getPopulation()).isEqualTo(DEFAULT_POPULATION);
        assertThat(testCrimeReport.getMurder()).isEqualTo(DEFAULT_MURDER);
        assertThat(testCrimeReport.getRape()).isEqualTo(DEFAULT_RAPE);
        assertThat(testCrimeReport.getRobbery()).isEqualTo(DEFAULT_ROBBERY);
        assertThat(testCrimeReport.getAggravatedAssault()).isEqualTo(DEFAULT_AGGRAVATED_ASSAULT);
        assertThat(testCrimeReport.getPropertyCrime()).isEqualTo(DEFAULT_PROPERTY_CRIME);
        assertThat(testCrimeReport.getBurglary()).isEqualTo(DEFAULT_BURGLARY);
        assertThat(testCrimeReport.getLarceny()).isEqualTo(DEFAULT_LARCENY);
        assertThat(testCrimeReport.getVehicleTheft()).isEqualTo(DEFAULT_VEHICLE_THEFT);
        assertThat(testCrimeReport.getArson()).isEqualTo(DEFAULT_ARSON);
    }

    @Test
    @Transactional
    void createCrimeReportWithExistingId() throws Exception {
        // Create the CrimeReport with an existing ID
        crimeReport.setId(1L);
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(crimeReport);

        int databaseSizeBeforeCreate = crimeReportRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCrimeReportMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(crimeReportDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllCrimeReports() throws Exception {
        // Initialize the database
        crimeReportRepository.saveAndFlush(crimeReport);

        // Get all the crimeReportList
        restCrimeReportMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(crimeReport.getId().intValue())))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].population").value(hasItem(DEFAULT_POPULATION)))
            .andExpect(jsonPath("$.[*].murder").value(hasItem(DEFAULT_MURDER)))
            .andExpect(jsonPath("$.[*].rape").value(hasItem(DEFAULT_RAPE)))
            .andExpect(jsonPath("$.[*].robbery").value(hasItem(DEFAULT_ROBBERY)))
            .andExpect(jsonPath("$.[*].aggravatedAssault").value(hasItem(DEFAULT_AGGRAVATED_ASSAULT)))
            .andExpect(jsonPath("$.[*].propertyCrime").value(hasItem(DEFAULT_PROPERTY_CRIME)))
            .andExpect(jsonPath("$.[*].burglary").value(hasItem(DEFAULT_BURGLARY)))
            .andExpect(jsonPath("$.[*].larceny").value(hasItem(DEFAULT_LARCENY)))
            .andExpect(jsonPath("$.[*].vehicleTheft").value(hasItem(DEFAULT_VEHICLE_THEFT)))
            .andExpect(jsonPath("$.[*].arson").value(hasItem(DEFAULT_ARSON)));
    }

    @Test
    @Transactional
    void getCrimeReport() throws Exception {
        // Initialize the database
        crimeReportRepository.saveAndFlush(crimeReport);

        // Get the crimeReport
        restCrimeReportMockMvc
            .perform(get(ENTITY_API_URL_ID, crimeReport.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(crimeReport.getId().intValue()))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.population").value(DEFAULT_POPULATION))
            .andExpect(jsonPath("$.murder").value(DEFAULT_MURDER))
            .andExpect(jsonPath("$.rape").value(DEFAULT_RAPE))
            .andExpect(jsonPath("$.robbery").value(DEFAULT_ROBBERY))
            .andExpect(jsonPath("$.aggravatedAssault").value(DEFAULT_AGGRAVATED_ASSAULT))
            .andExpect(jsonPath("$.propertyCrime").value(DEFAULT_PROPERTY_CRIME))
            .andExpect(jsonPath("$.burglary").value(DEFAULT_BURGLARY))
            .andExpect(jsonPath("$.larceny").value(DEFAULT_LARCENY))
            .andExpect(jsonPath("$.vehicleTheft").value(DEFAULT_VEHICLE_THEFT))
            .andExpect(jsonPath("$.arson").value(DEFAULT_ARSON));
    }

    @Test
    @Transactional
    void getNonExistingCrimeReport() throws Exception {
        // Get the crimeReport
        restCrimeReportMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewCrimeReport() throws Exception {
        // Initialize the database
        crimeReportRepository.saveAndFlush(crimeReport);

        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();

        // Update the crimeReport
        CrimeReport updatedCrimeReport = crimeReportRepository.findById(crimeReport.getId()).get();
        // Disconnect from session so that the updates on updatedCrimeReport are not directly saved in db
        em.detach(updatedCrimeReport);
        updatedCrimeReport
            .city(UPDATED_CITY)
            .population(UPDATED_POPULATION)
            .murder(UPDATED_MURDER)
            .rape(UPDATED_RAPE)
            .robbery(UPDATED_ROBBERY)
            .aggravatedAssault(UPDATED_AGGRAVATED_ASSAULT)
            .propertyCrime(UPDATED_PROPERTY_CRIME)
            .burglary(UPDATED_BURGLARY)
            .larceny(UPDATED_LARCENY)
            .vehicleTheft(UPDATED_VEHICLE_THEFT)
            .arson(UPDATED_ARSON);
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(updatedCrimeReport);

        restCrimeReportMockMvc
            .perform(
                put(ENTITY_API_URL_ID, crimeReportDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(crimeReportDTO))
            )
            .andExpect(status().isOk());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
        CrimeReport testCrimeReport = crimeReportList.get(crimeReportList.size() - 1);
        assertThat(testCrimeReport.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testCrimeReport.getPopulation()).isEqualTo(UPDATED_POPULATION);
        assertThat(testCrimeReport.getMurder()).isEqualTo(UPDATED_MURDER);
        assertThat(testCrimeReport.getRape()).isEqualTo(UPDATED_RAPE);
        assertThat(testCrimeReport.getRobbery()).isEqualTo(UPDATED_ROBBERY);
        assertThat(testCrimeReport.getAggravatedAssault()).isEqualTo(UPDATED_AGGRAVATED_ASSAULT);
        assertThat(testCrimeReport.getPropertyCrime()).isEqualTo(UPDATED_PROPERTY_CRIME);
        assertThat(testCrimeReport.getBurglary()).isEqualTo(UPDATED_BURGLARY);
        assertThat(testCrimeReport.getLarceny()).isEqualTo(UPDATED_LARCENY);
        assertThat(testCrimeReport.getVehicleTheft()).isEqualTo(UPDATED_VEHICLE_THEFT);
        assertThat(testCrimeReport.getArson()).isEqualTo(UPDATED_ARSON);
    }

    @Test
    @Transactional
    void putNonExistingCrimeReport() throws Exception {
        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();
        crimeReport.setId(count.incrementAndGet());

        // Create the CrimeReport
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(crimeReport);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCrimeReportMockMvc
            .perform(
                put(ENTITY_API_URL_ID, crimeReportDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(crimeReportDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchCrimeReport() throws Exception {
        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();
        crimeReport.setId(count.incrementAndGet());

        // Create the CrimeReport
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(crimeReport);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCrimeReportMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(crimeReportDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamCrimeReport() throws Exception {
        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();
        crimeReport.setId(count.incrementAndGet());

        // Create the CrimeReport
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(crimeReport);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCrimeReportMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(crimeReportDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateCrimeReportWithPatch() throws Exception {
        // Initialize the database
        crimeReportRepository.saveAndFlush(crimeReport);

        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();

        // Update the crimeReport using partial update
        CrimeReport partialUpdatedCrimeReport = new CrimeReport();
        partialUpdatedCrimeReport.setId(crimeReport.getId());

        partialUpdatedCrimeReport
            .rape(UPDATED_RAPE)
            .robbery(UPDATED_ROBBERY)
            .aggravatedAssault(UPDATED_AGGRAVATED_ASSAULT)
            .propertyCrime(UPDATED_PROPERTY_CRIME)
            .larceny(UPDATED_LARCENY);

        restCrimeReportMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCrimeReport.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCrimeReport))
            )
            .andExpect(status().isOk());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
        CrimeReport testCrimeReport = crimeReportList.get(crimeReportList.size() - 1);
        assertThat(testCrimeReport.getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(testCrimeReport.getPopulation()).isEqualTo(DEFAULT_POPULATION);
        assertThat(testCrimeReport.getMurder()).isEqualTo(DEFAULT_MURDER);
        assertThat(testCrimeReport.getRape()).isEqualTo(UPDATED_RAPE);
        assertThat(testCrimeReport.getRobbery()).isEqualTo(UPDATED_ROBBERY);
        assertThat(testCrimeReport.getAggravatedAssault()).isEqualTo(UPDATED_AGGRAVATED_ASSAULT);
        assertThat(testCrimeReport.getPropertyCrime()).isEqualTo(UPDATED_PROPERTY_CRIME);
        assertThat(testCrimeReport.getBurglary()).isEqualTo(DEFAULT_BURGLARY);
        assertThat(testCrimeReport.getLarceny()).isEqualTo(UPDATED_LARCENY);
        assertThat(testCrimeReport.getVehicleTheft()).isEqualTo(DEFAULT_VEHICLE_THEFT);
        assertThat(testCrimeReport.getArson()).isEqualTo(DEFAULT_ARSON);
    }

    @Test
    @Transactional
    void fullUpdateCrimeReportWithPatch() throws Exception {
        // Initialize the database
        crimeReportRepository.saveAndFlush(crimeReport);

        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();

        // Update the crimeReport using partial update
        CrimeReport partialUpdatedCrimeReport = new CrimeReport();
        partialUpdatedCrimeReport.setId(crimeReport.getId());

        partialUpdatedCrimeReport
            .city(UPDATED_CITY)
            .population(UPDATED_POPULATION)
            .murder(UPDATED_MURDER)
            .rape(UPDATED_RAPE)
            .robbery(UPDATED_ROBBERY)
            .aggravatedAssault(UPDATED_AGGRAVATED_ASSAULT)
            .propertyCrime(UPDATED_PROPERTY_CRIME)
            .burglary(UPDATED_BURGLARY)
            .larceny(UPDATED_LARCENY)
            .vehicleTheft(UPDATED_VEHICLE_THEFT)
            .arson(UPDATED_ARSON);

        restCrimeReportMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCrimeReport.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCrimeReport))
            )
            .andExpect(status().isOk());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
        CrimeReport testCrimeReport = crimeReportList.get(crimeReportList.size() - 1);
        assertThat(testCrimeReport.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testCrimeReport.getPopulation()).isEqualTo(UPDATED_POPULATION);
        assertThat(testCrimeReport.getMurder()).isEqualTo(UPDATED_MURDER);
        assertThat(testCrimeReport.getRape()).isEqualTo(UPDATED_RAPE);
        assertThat(testCrimeReport.getRobbery()).isEqualTo(UPDATED_ROBBERY);
        assertThat(testCrimeReport.getAggravatedAssault()).isEqualTo(UPDATED_AGGRAVATED_ASSAULT);
        assertThat(testCrimeReport.getPropertyCrime()).isEqualTo(UPDATED_PROPERTY_CRIME);
        assertThat(testCrimeReport.getBurglary()).isEqualTo(UPDATED_BURGLARY);
        assertThat(testCrimeReport.getLarceny()).isEqualTo(UPDATED_LARCENY);
        assertThat(testCrimeReport.getVehicleTheft()).isEqualTo(UPDATED_VEHICLE_THEFT);
        assertThat(testCrimeReport.getArson()).isEqualTo(UPDATED_ARSON);
    }

    @Test
    @Transactional
    void patchNonExistingCrimeReport() throws Exception {
        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();
        crimeReport.setId(count.incrementAndGet());

        // Create the CrimeReport
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(crimeReport);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCrimeReportMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, crimeReportDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(crimeReportDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchCrimeReport() throws Exception {
        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();
        crimeReport.setId(count.incrementAndGet());

        // Create the CrimeReport
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(crimeReport);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCrimeReportMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(crimeReportDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamCrimeReport() throws Exception {
        int databaseSizeBeforeUpdate = crimeReportRepository.findAll().size();
        crimeReport.setId(count.incrementAndGet());

        // Create the CrimeReport
        CrimeReportDTO crimeReportDTO = crimeReportMapper.toDto(crimeReport);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCrimeReportMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(crimeReportDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the CrimeReport in the database
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteCrimeReport() throws Exception {
        // Initialize the database
        crimeReportRepository.saveAndFlush(crimeReport);

        int databaseSizeBeforeDelete = crimeReportRepository.findAll().size();

        // Delete the crimeReport
        restCrimeReportMockMvc
            .perform(delete(ENTITY_API_URL_ID, crimeReport.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CrimeReport> crimeReportList = crimeReportRepository.findAll();
        assertThat(crimeReportList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
