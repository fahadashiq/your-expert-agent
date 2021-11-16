package com.hsrw.yea.service;

import com.hsrw.yea.domain.ResProperties;
import com.hsrw.yea.repository.ResPropertiesRepository;
import com.hsrw.yea.service.dto.ResPropertiesDTO;
import com.hsrw.yea.service.mapper.ResPropertiesMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ResProperties}.
 */
@Service
@Transactional
public class ResPropertiesService {

    private final Logger log = LoggerFactory.getLogger(ResPropertiesService.class);

    private final ResPropertiesRepository resPropertiesRepository;

    private final ResPropertiesMapper resPropertiesMapper;

    public ResPropertiesService(ResPropertiesRepository resPropertiesRepository, ResPropertiesMapper resPropertiesMapper) {
        this.resPropertiesRepository = resPropertiesRepository;
        this.resPropertiesMapper = resPropertiesMapper;
    }

    /**
     * Save a resProperties.
     *
     * @param resPropertiesDTO the entity to save.
     * @return the persisted entity.
     */
    public ResPropertiesDTO save(ResPropertiesDTO resPropertiesDTO) {
        log.debug("Request to save ResProperties : {}", resPropertiesDTO);
        ResProperties resProperties = resPropertiesMapper.toEntity(resPropertiesDTO);
        resProperties = resPropertiesRepository.save(resProperties);
        return resPropertiesMapper.toDto(resProperties);
    }

    /**
     * Partially update a resProperties.
     *
     * @param resPropertiesDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ResPropertiesDTO> partialUpdate(ResPropertiesDTO resPropertiesDTO) {
        log.debug("Request to partially update ResProperties : {}", resPropertiesDTO);

        return resPropertiesRepository
            .findById(resPropertiesDTO.getId())
            .map(existingResProperties -> {
                resPropertiesMapper.partialUpdate(existingResProperties, resPropertiesDTO);

                return existingResProperties;
            })
            .map(resPropertiesRepository::save)
            .map(resPropertiesMapper::toDto);
    }

    /**
     * Get all the resProperties.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ResPropertiesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ResProperties");
        return resPropertiesRepository.findAll(pageable).map(resPropertiesMapper::toDto);
    }

    /**
     * Get one resProperties by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ResPropertiesDTO> findOne(Long id) {
        log.debug("Request to get ResProperties : {}", id);
        return resPropertiesRepository.findById(id).map(resPropertiesMapper::toDto);
    }

    /**
     * Delete the resProperties by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ResProperties : {}", id);
        resPropertiesRepository.deleteById(id);
    }
}
