package com.hsrw.yea.service;

import com.hsrw.yea.domain.UserInfo;
import com.hsrw.yea.repository.UserInfoRepository;
import com.hsrw.yea.service.dto.UserInfoDTO;
import com.hsrw.yea.service.mapper.UserInfoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link UserInfo}.
 */
@Service
@Transactional
public class UserInfoService {

    private final Logger log = LoggerFactory.getLogger(UserInfoService.class);

    private final UserInfoRepository userInfoRepository;

    private final UserInfoMapper userInfoMapper;

    public UserInfoService(UserInfoRepository userInfoRepository, UserInfoMapper userInfoMapper) {
        this.userInfoRepository = userInfoRepository;
        this.userInfoMapper = userInfoMapper;
    }

    /**
     * Save a userInfo.
     *
     * @param userInfoDTO the entity to save.
     * @return the persisted entity.
     */
    public UserInfoDTO save(UserInfoDTO userInfoDTO) {
        log.debug("Request to save UserInfo : {}", userInfoDTO);
        UserInfo userInfo = userInfoMapper.toEntity(userInfoDTO);
        userInfo = userInfoRepository.save(userInfo);
        return userInfoMapper.toDto(userInfo);
    }

    /**
     * Partially update a userInfo.
     *
     * @param userInfoDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<UserInfoDTO> partialUpdate(UserInfoDTO userInfoDTO) {
        log.debug("Request to partially update UserInfo : {}", userInfoDTO);

        return userInfoRepository
            .findById(userInfoDTO.getId())
            .map(existingUserInfo -> {
                userInfoMapper.partialUpdate(existingUserInfo, userInfoDTO);

                return existingUserInfo;
            })
            .map(userInfoRepository::save)
            .map(userInfoMapper::toDto);
    }

    /**
     * Get all the userInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserInfos");
        return userInfoRepository.findAll(pageable).map(userInfoMapper::toDto);
    }

    /**
     * Get one userInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserInfoDTO> findOne(Long id) {
        log.debug("Request to get UserInfo : {}", id);
        return userInfoRepository.findById(id).map(userInfoMapper::toDto);
    }

    /**
     * Delete the userInfo by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserInfo : {}", id);
        userInfoRepository.deleteById(id);
    }
}
