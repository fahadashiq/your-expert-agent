package com.hsrw.yea.service;

import com.hsrw.yea.domain.SearchCriteria;
import com.hsrw.yea.repository.SearchCriteriaRepository;
import com.hsrw.yea.service.dto.SearchCriteriaDTO;
import com.hsrw.yea.service.mapper.SearchCriteriaMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link SearchCriteria}.
 */
@Service
@Transactional
public class SearchCriteriaService {

    private final Logger log = LoggerFactory.getLogger(SearchCriteriaService.class);

    private final SearchCriteriaRepository searchCriteriaRepository;

    private final SearchCriteriaMapper searchCriteriaMapper;

    public SearchCriteriaService(SearchCriteriaRepository searchCriteriaRepository, SearchCriteriaMapper searchCriteriaMapper) {
        this.searchCriteriaRepository = searchCriteriaRepository;
        this.searchCriteriaMapper = searchCriteriaMapper;
    }

    /**
     * Save a searchCriteria.
     *
     * @param searchCriteriaDTO the entity to save.
     * @return the persisted entity.
     */
    public SearchCriteriaDTO save(SearchCriteriaDTO searchCriteriaDTO) {
        log.debug("Request to save SearchCriteria : {}", searchCriteriaDTO);
        SearchCriteria searchCriteria = searchCriteriaMapper.toEntity(searchCriteriaDTO);
        searchCriteria = searchCriteriaRepository.save(searchCriteria);
        return searchCriteriaMapper.toDto(searchCriteria);
    }

    /**
     * Partially update a searchCriteria.
     *
     * @param searchCriteriaDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<SearchCriteriaDTO> partialUpdate(SearchCriteriaDTO searchCriteriaDTO) {
        log.debug("Request to partially update SearchCriteria : {}", searchCriteriaDTO);

        return searchCriteriaRepository
            .findById(searchCriteriaDTO.getId())
            .map(existingSearchCriteria -> {
                searchCriteriaMapper.partialUpdate(existingSearchCriteria, searchCriteriaDTO);

                return existingSearchCriteria;
            })
            .map(searchCriteriaRepository::save)
            .map(searchCriteriaMapper::toDto);
    }

    /**
     * Get all the searchCriteria.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<SearchCriteriaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SearchCriteria");
        return searchCriteriaRepository.findAll(pageable).map(searchCriteriaMapper::toDto);
    }

    /**
     * Get one searchCriteria by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SearchCriteriaDTO> findOne(Long id) {
        log.debug("Request to get SearchCriteria : {}", id);
        return searchCriteriaRepository.findById(id).map(searchCriteriaMapper::toDto);
    }

    /**
     * Delete the searchCriteria by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SearchCriteria : {}", id);
        searchCriteriaRepository.deleteById(id);
    }
}
