package com.hsrw.yea.web.rest;

import com.hsrw.yea.repository.SearchCriteriaRepository;
import com.hsrw.yea.service.SearchCriteriaService;
import com.hsrw.yea.service.dto.SearchCriteriaDTO;
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
 * REST controller for managing {@link com.hsrw.yea.domain.SearchCriteria}.
 */
@RestController
@RequestMapping("/api")
public class SearchCriteriaResource {

    private final Logger log = LoggerFactory.getLogger(SearchCriteriaResource.class);

    private static final String ENTITY_NAME = "searchCriteria";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SearchCriteriaService searchCriteriaService;

    private final SearchCriteriaRepository searchCriteriaRepository;

    public SearchCriteriaResource(SearchCriteriaService searchCriteriaService, SearchCriteriaRepository searchCriteriaRepository) {
        this.searchCriteriaService = searchCriteriaService;
        this.searchCriteriaRepository = searchCriteriaRepository;
    }

    /**
     * {@code POST  /search-criteria} : Create a new searchCriteria.
     *
     * @param searchCriteriaDTO the searchCriteriaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new searchCriteriaDTO, or with status {@code 400 (Bad Request)} if the searchCriteria has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/search-criteria")
    public ResponseEntity<SearchCriteriaDTO> createSearchCriteria(@Valid @RequestBody SearchCriteriaDTO searchCriteriaDTO)
        throws URISyntaxException {
        log.debug("REST request to save SearchCriteria : {}", searchCriteriaDTO);
        if (searchCriteriaDTO.getId() != null) {
            throw new BadRequestAlertException("A new searchCriteria cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SearchCriteriaDTO result = searchCriteriaService.save(searchCriteriaDTO);
        return ResponseEntity
            .created(new URI("/api/search-criteria/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /search-criteria/:id} : Updates an existing searchCriteria.
     *
     * @param id the id of the searchCriteriaDTO to save.
     * @param searchCriteriaDTO the searchCriteriaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated searchCriteriaDTO,
     * or with status {@code 400 (Bad Request)} if the searchCriteriaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the searchCriteriaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/search-criteria/{id}")
    public ResponseEntity<SearchCriteriaDTO> updateSearchCriteria(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SearchCriteriaDTO searchCriteriaDTO
    ) throws URISyntaxException {
        log.debug("REST request to update SearchCriteria : {}, {}", id, searchCriteriaDTO);
        if (searchCriteriaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, searchCriteriaDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!searchCriteriaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SearchCriteriaDTO result = searchCriteriaService.save(searchCriteriaDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, searchCriteriaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /search-criteria/:id} : Partial updates given fields of an existing searchCriteria, field will ignore if it is null
     *
     * @param id the id of the searchCriteriaDTO to save.
     * @param searchCriteriaDTO the searchCriteriaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated searchCriteriaDTO,
     * or with status {@code 400 (Bad Request)} if the searchCriteriaDTO is not valid,
     * or with status {@code 404 (Not Found)} if the searchCriteriaDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the searchCriteriaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/search-criteria/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SearchCriteriaDTO> partialUpdateSearchCriteria(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SearchCriteriaDTO searchCriteriaDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update SearchCriteria partially : {}, {}", id, searchCriteriaDTO);
        if (searchCriteriaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, searchCriteriaDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!searchCriteriaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SearchCriteriaDTO> result = searchCriteriaService.partialUpdate(searchCriteriaDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, searchCriteriaDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /search-criteria} : get all the searchCriteria.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of searchCriteria in body.
     */
    @GetMapping("/search-criteria")
    public ResponseEntity<List<SearchCriteriaDTO>> getAllSearchCriteria(Pageable pageable) {
        log.debug("REST request to get a page of SearchCriteria");
        Page<SearchCriteriaDTO> page = searchCriteriaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /search-criteria/:id} : get the "id" searchCriteria.
     *
     * @param id the id of the searchCriteriaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the searchCriteriaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/search-criteria/{id}")
    public ResponseEntity<SearchCriteriaDTO> getSearchCriteria(@PathVariable Long id) {
        log.debug("REST request to get SearchCriteria : {}", id);
        Optional<SearchCriteriaDTO> searchCriteriaDTO = searchCriteriaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(searchCriteriaDTO);
    }

    /**
     * {@code DELETE  /search-criteria/:id} : delete the "id" searchCriteria.
     *
     * @param id the id of the searchCriteriaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/search-criteria/{id}")
    public ResponseEntity<Void> deleteSearchCriteria(@PathVariable Long id) {
        log.debug("REST request to delete SearchCriteria : {}", id);
        searchCriteriaService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
