package com.hsrw.yea.web.rest;

import com.hsrw.yea.repository.CrimeReportRepository;
import com.hsrw.yea.service.CrimeReportService;
import com.hsrw.yea.service.dto.CrimeReportDTO;
import com.hsrw.yea.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.hsrw.yea.domain.CrimeReport}.
 */
@RestController
@RequestMapping("/api")
public class CrimeReportResource {

    private final Logger log = LoggerFactory.getLogger(CrimeReportResource.class);

    private static final String ENTITY_NAME = "crimeReport";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CrimeReportService crimeReportService;

    private final CrimeReportRepository crimeReportRepository;

    public CrimeReportResource(CrimeReportService crimeReportService, CrimeReportRepository crimeReportRepository) {
        this.crimeReportService = crimeReportService;
        this.crimeReportRepository = crimeReportRepository;
    }

    /**
     * {@code POST  /crime-reports} : Create a new crimeReport.
     *
     * @param crimeReportDTO the crimeReportDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new crimeReportDTO, or with status {@code 400 (Bad Request)} if the crimeReport has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/crime-reports")
    public ResponseEntity<CrimeReportDTO> createCrimeReport(@RequestBody CrimeReportDTO crimeReportDTO) throws URISyntaxException {
        log.debug("REST request to save CrimeReport : {}", crimeReportDTO);
        if (crimeReportDTO.getId() != null) {
            throw new BadRequestAlertException("A new crimeReport cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CrimeReportDTO result = crimeReportService.save(crimeReportDTO);
        return ResponseEntity
            .created(new URI("/api/crime-reports/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /crime-reports/:id} : Updates an existing crimeReport.
     *
     * @param id the id of the crimeReportDTO to save.
     * @param crimeReportDTO the crimeReportDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated crimeReportDTO,
     * or with status {@code 400 (Bad Request)} if the crimeReportDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the crimeReportDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/crime-reports/{id}")
    public ResponseEntity<CrimeReportDTO> updateCrimeReport(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CrimeReportDTO crimeReportDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CrimeReport : {}, {}", id, crimeReportDTO);
        if (crimeReportDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, crimeReportDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!crimeReportRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CrimeReportDTO result = crimeReportService.save(crimeReportDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, crimeReportDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /crime-reports/:id} : Partial updates given fields of an existing crimeReport, field will ignore if it is null
     *
     * @param id the id of the crimeReportDTO to save.
     * @param crimeReportDTO the crimeReportDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated crimeReportDTO,
     * or with status {@code 400 (Bad Request)} if the crimeReportDTO is not valid,
     * or with status {@code 404 (Not Found)} if the crimeReportDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the crimeReportDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/crime-reports/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CrimeReportDTO> partialUpdateCrimeReport(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CrimeReportDTO crimeReportDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update CrimeReport partially : {}, {}", id, crimeReportDTO);
        if (crimeReportDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, crimeReportDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!crimeReportRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CrimeReportDTO> result = crimeReportService.partialUpdate(crimeReportDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, crimeReportDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /crime-reports} : get all the crimeReports.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of crimeReports in body.
     */
    @GetMapping("/crime-reports")
    public ResponseEntity<List<CrimeReportDTO>> getAllCrimeReports(Pageable pageable) {
        log.debug("REST request to get a page of CrimeReports");
        Page<CrimeReportDTO> page = crimeReportService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /crime-reports/:id} : get the "id" crimeReport.
     *
     * @param id the id of the crimeReportDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the crimeReportDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/crime-reports/{id}")
    public ResponseEntity<CrimeReportDTO> getCrimeReport(@PathVariable Long id) {
        log.debug("REST request to get CrimeReport : {}", id);
        Optional<CrimeReportDTO> crimeReportDTO = crimeReportService.findOne(id);
        return ResponseUtil.wrapOrNotFound(crimeReportDTO);
    }

    /**
     * {@code DELETE  /crime-reports/:id} : delete the "id" crimeReport.
     *
     * @param id the id of the crimeReportDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/crime-reports/{id}")
    public ResponseEntity<Void> deleteCrimeReport(@PathVariable Long id) {
        log.debug("REST request to delete CrimeReport : {}", id);
        crimeReportService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
