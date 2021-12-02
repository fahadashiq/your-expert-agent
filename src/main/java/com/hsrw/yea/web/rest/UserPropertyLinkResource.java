package com.hsrw.yea.web.rest;

import com.hsrw.yea.repository.UserPropertyLinkRepository;
import com.hsrw.yea.service.UserPropertyLinkService;
import com.hsrw.yea.service.dto.UserPropertyLinkDTO;
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
 * REST controller for managing {@link com.hsrw.yea.domain.UserPropertyLink}.
 */
@RestController
@RequestMapping("/api")
public class UserPropertyLinkResource {

    private final Logger log = LoggerFactory.getLogger(UserPropertyLinkResource.class);

    private static final String ENTITY_NAME = "userPropertyLink";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserPropertyLinkService userPropertyLinkService;

    private final UserPropertyLinkRepository userPropertyLinkRepository;

    public UserPropertyLinkResource(
        UserPropertyLinkService userPropertyLinkService,
        UserPropertyLinkRepository userPropertyLinkRepository
    ) {
        this.userPropertyLinkService = userPropertyLinkService;
        this.userPropertyLinkRepository = userPropertyLinkRepository;
    }

    /**
     * {@code POST  /user-property-links} : Create a new userPropertyLink.
     *
     * @param userPropertyLinkDTO the userPropertyLinkDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userPropertyLinkDTO, or with status {@code 400 (Bad Request)} if the userPropertyLink has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-property-links")
    public ResponseEntity<UserPropertyLinkDTO> createUserPropertyLink(@RequestBody UserPropertyLinkDTO userPropertyLinkDTO)
        throws URISyntaxException {
        log.debug("REST request to save UserPropertyLink : {}", userPropertyLinkDTO);
        if (userPropertyLinkDTO.getId() != null) {
            throw new BadRequestAlertException("A new userPropertyLink cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserPropertyLinkDTO result = userPropertyLinkService.save(userPropertyLinkDTO);
        return ResponseEntity
            .created(new URI("/api/user-property-links/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-property-links/:id} : Updates an existing userPropertyLink.
     *
     * @param id the id of the userPropertyLinkDTO to save.
     * @param userPropertyLinkDTO the userPropertyLinkDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userPropertyLinkDTO,
     * or with status {@code 400 (Bad Request)} if the userPropertyLinkDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userPropertyLinkDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-property-links/{id}")
    public ResponseEntity<UserPropertyLinkDTO> updateUserPropertyLink(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody UserPropertyLinkDTO userPropertyLinkDTO
    ) throws URISyntaxException {
        log.debug("REST request to update UserPropertyLink : {}, {}", id, userPropertyLinkDTO);
        if (userPropertyLinkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, userPropertyLinkDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!userPropertyLinkRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        UserPropertyLinkDTO result = userPropertyLinkService.save(userPropertyLinkDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, userPropertyLinkDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /user-property-links/:id} : Partial updates given fields of an existing userPropertyLink, field will ignore if it is null
     *
     * @param id the id of the userPropertyLinkDTO to save.
     * @param userPropertyLinkDTO the userPropertyLinkDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userPropertyLinkDTO,
     * or with status {@code 400 (Bad Request)} if the userPropertyLinkDTO is not valid,
     * or with status {@code 404 (Not Found)} if the userPropertyLinkDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the userPropertyLinkDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/user-property-links/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<UserPropertyLinkDTO> partialUpdateUserPropertyLink(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody UserPropertyLinkDTO userPropertyLinkDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update UserPropertyLink partially : {}, {}", id, userPropertyLinkDTO);
        if (userPropertyLinkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, userPropertyLinkDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!userPropertyLinkRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<UserPropertyLinkDTO> result = userPropertyLinkService.partialUpdate(userPropertyLinkDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, userPropertyLinkDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /user-property-links} : get all the userPropertyLinks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userPropertyLinks in body.
     */
    @GetMapping("/user-property-links")
    public ResponseEntity<List<UserPropertyLinkDTO>> getAllUserPropertyLinks(Pageable pageable) {
        log.debug("REST request to get a page of UserPropertyLinks");
        Page<UserPropertyLinkDTO> page = userPropertyLinkService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-property-links/:id} : get the "id" userPropertyLink.
     *
     * @param id the id of the userPropertyLinkDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userPropertyLinkDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-property-links/{id}")
    public ResponseEntity<UserPropertyLinkDTO> getUserPropertyLink(@PathVariable Long id) {
        log.debug("REST request to get UserPropertyLink : {}", id);
        Optional<UserPropertyLinkDTO> userPropertyLinkDTO = userPropertyLinkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userPropertyLinkDTO);
    }

    /**
     * {@code DELETE  /user-property-links/:id} : delete the "id" userPropertyLink.
     *
     * @param id the id of the userPropertyLinkDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-property-links/{id}")
    public ResponseEntity<Void> deleteUserPropertyLink(@PathVariable Long id) {
        log.debug("REST request to delete UserPropertyLink : {}", id);
        userPropertyLinkService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
