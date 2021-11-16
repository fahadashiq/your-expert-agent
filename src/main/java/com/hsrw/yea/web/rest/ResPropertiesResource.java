package com.hsrw.yea.web.rest;

import com.hsrw.yea.repository.ResPropertiesRepository;
import com.hsrw.yea.service.ResPropertiesService;
import com.hsrw.yea.service.dto.ResPropertiesDTO;
import com.hsrw.yea.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
 * REST controller for managing {@link com.hsrw.yea.domain.ResProperties}.
 */
@RestController
@RequestMapping("/api")
public class ResPropertiesResource {

    private final Logger log = LoggerFactory.getLogger(ResPropertiesResource.class);

    private static final String ENTITY_NAME = "resProperties";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ResPropertiesService resPropertiesService;

    private final ResPropertiesRepository resPropertiesRepository;

    public ResPropertiesResource(ResPropertiesService resPropertiesService, ResPropertiesRepository resPropertiesRepository) {
        this.resPropertiesService = resPropertiesService;
        this.resPropertiesRepository = resPropertiesRepository;
    }

    /**
     * {@code POST  /res-properties} : Create a new resProperties.
     *
     * @param resPropertiesDTO the resPropertiesDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new resPropertiesDTO, or with status {@code 400 (Bad Request)} if the resProperties has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/res-properties")
    public ResponseEntity<ResPropertiesDTO> createResProperties(@Valid @RequestBody ResPropertiesDTO resPropertiesDTO)
        throws URISyntaxException {
        log.debug("REST request to save ResProperties : {}", resPropertiesDTO);
        if (resPropertiesDTO.getId() != null) {
            throw new BadRequestAlertException("A new resProperties cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ResPropertiesDTO result = resPropertiesService.save(resPropertiesDTO);
        return ResponseEntity
            .created(new URI("/api/res-properties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /res-properties/:id} : Updates an existing resProperties.
     *
     * @param id the id of the resPropertiesDTO to save.
     * @param resPropertiesDTO the resPropertiesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resPropertiesDTO,
     * or with status {@code 400 (Bad Request)} if the resPropertiesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the resPropertiesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/res-properties/{id}")
    public ResponseEntity<ResPropertiesDTO> updateResProperties(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ResPropertiesDTO resPropertiesDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ResProperties : {}, {}", id, resPropertiesDTO);
        if (resPropertiesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resPropertiesDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resPropertiesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ResPropertiesDTO result = resPropertiesService.save(resPropertiesDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resPropertiesDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /res-properties/:id} : Partial updates given fields of an existing resProperties, field will ignore if it is null
     *
     * @param id the id of the resPropertiesDTO to save.
     * @param resPropertiesDTO the resPropertiesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resPropertiesDTO,
     * or with status {@code 400 (Bad Request)} if the resPropertiesDTO is not valid,
     * or with status {@code 404 (Not Found)} if the resPropertiesDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the resPropertiesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/res-properties/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ResPropertiesDTO> partialUpdateResProperties(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ResPropertiesDTO resPropertiesDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ResProperties partially : {}, {}", id, resPropertiesDTO);
        if (resPropertiesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resPropertiesDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resPropertiesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ResPropertiesDTO> result = resPropertiesService.partialUpdate(resPropertiesDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resPropertiesDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /res-properties} : get all the resProperties.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of resProperties in body.
     */
    @GetMapping("/res-properties")
    public ResponseEntity<List<ResPropertiesDTO>> getAllResProperties(Pageable pageable) {
        log.debug("REST request to get a page of ResProperties");
        Page<ResPropertiesDTO> page = resPropertiesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /res-properties/:id} : get the "id" resProperties.
     *
     * @param id the id of the resPropertiesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the resPropertiesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/res-properties/{id}")
    public ResponseEntity<ResPropertiesDTO> getResProperties(@PathVariable Long id) {
        log.debug("REST request to get ResProperties : {}", id);
        Optional<ResPropertiesDTO> resPropertiesDTO = resPropertiesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(resPropertiesDTO);
    }

    /**
     * {@code DELETE  /res-properties/:id} : delete the "id" resProperties.
     *
     * @param id the id of the resPropertiesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/res-properties/{id}")
    public ResponseEntity<Void> deleteResProperties(@PathVariable Long id) {
        log.debug("REST request to delete ResProperties : {}", id);
        resPropertiesService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
