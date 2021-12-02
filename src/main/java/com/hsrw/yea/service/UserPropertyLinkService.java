package com.hsrw.yea.service;

import com.hsrw.yea.domain.UserPropertyLink;
import com.hsrw.yea.repository.UserPropertyLinkRepository;
import com.hsrw.yea.service.dto.UserPropertyLinkDTO;
import com.hsrw.yea.service.mapper.UserPropertyLinkMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link UserPropertyLink}.
 */
@Service
@Transactional
public class UserPropertyLinkService {

    private final Logger log = LoggerFactory.getLogger(UserPropertyLinkService.class);

    private final UserPropertyLinkRepository userPropertyLinkRepository;

    private final UserPropertyLinkMapper userPropertyLinkMapper;

    public UserPropertyLinkService(UserPropertyLinkRepository userPropertyLinkRepository, UserPropertyLinkMapper userPropertyLinkMapper) {
        this.userPropertyLinkRepository = userPropertyLinkRepository;
        this.userPropertyLinkMapper = userPropertyLinkMapper;
    }

    /**
     * Save a userPropertyLink.
     *
     * @param userPropertyLinkDTO the entity to save.
     * @return the persisted entity.
     */
    public UserPropertyLinkDTO save(UserPropertyLinkDTO userPropertyLinkDTO) {
        log.debug("Request to save UserPropertyLink : {}", userPropertyLinkDTO);
        UserPropertyLink userPropertyLink = userPropertyLinkMapper.toEntity(userPropertyLinkDTO);
        userPropertyLink = userPropertyLinkRepository.save(userPropertyLink);
        return userPropertyLinkMapper.toDto(userPropertyLink);
    }

    /**
     * Partially update a userPropertyLink.
     *
     * @param userPropertyLinkDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<UserPropertyLinkDTO> partialUpdate(UserPropertyLinkDTO userPropertyLinkDTO) {
        log.debug("Request to partially update UserPropertyLink : {}", userPropertyLinkDTO);

        return userPropertyLinkRepository
            .findById(userPropertyLinkDTO.getId())
            .map(existingUserPropertyLink -> {
                userPropertyLinkMapper.partialUpdate(existingUserPropertyLink, userPropertyLinkDTO);

                return existingUserPropertyLink;
            })
            .map(userPropertyLinkRepository::save)
            .map(userPropertyLinkMapper::toDto);
    }

    /**
     * Get all the userPropertyLinks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserPropertyLinkDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserPropertyLinks");
        return userPropertyLinkRepository.findAll(pageable).map(userPropertyLinkMapper::toDto);
    }

    /**
     * Get one userPropertyLink by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserPropertyLinkDTO> findOne(Long id) {
        log.debug("Request to get UserPropertyLink : {}", id);
        return userPropertyLinkRepository.findById(id).map(userPropertyLinkMapper::toDto);
    }

    /**
     * Delete the userPropertyLink by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserPropertyLink : {}", id);
        userPropertyLinkRepository.deleteById(id);
    }
}
