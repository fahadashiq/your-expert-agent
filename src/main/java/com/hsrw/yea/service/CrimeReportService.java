package com.hsrw.yea.service;

import com.hsrw.yea.domain.CrimeReport;
import com.hsrw.yea.repository.CrimeReportRepository;
import com.hsrw.yea.service.dto.CrimeReportDTO;
import com.hsrw.yea.service.mapper.CrimeReportMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CrimeReport}.
 */
@Service
@Transactional
public class CrimeReportService {

    private final Logger log = LoggerFactory.getLogger(CrimeReportService.class);

    private final CrimeReportRepository crimeReportRepository;

    private final CrimeReportMapper crimeReportMapper;

    public CrimeReportService(CrimeReportRepository crimeReportRepository, CrimeReportMapper crimeReportMapper) {
        this.crimeReportRepository = crimeReportRepository;
        this.crimeReportMapper = crimeReportMapper;
    }

    /**
     * Save a crimeReport.
     *
     * @param crimeReportDTO the entity to save.
     * @return the persisted entity.
     */
    public CrimeReportDTO save(CrimeReportDTO crimeReportDTO) {
        log.debug("Request to save CrimeReport : {}", crimeReportDTO);
        CrimeReport crimeReport = crimeReportMapper.toEntity(crimeReportDTO);
        crimeReport = crimeReportRepository.save(crimeReport);
        return crimeReportMapper.toDto(crimeReport);
    }

    /**
     * Partially update a crimeReport.
     *
     * @param crimeReportDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CrimeReportDTO> partialUpdate(CrimeReportDTO crimeReportDTO) {
        log.debug("Request to partially update CrimeReport : {}", crimeReportDTO);

        return crimeReportRepository
            .findById(crimeReportDTO.getId())
            .map(existingCrimeReport -> {
                crimeReportMapper.partialUpdate(existingCrimeReport, crimeReportDTO);

                return existingCrimeReport;
            })
            .map(crimeReportRepository::save)
            .map(crimeReportMapper::toDto);
    }

    /**
     * Get all the crimeReports.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CrimeReportDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CrimeReports");
        return crimeReportRepository.findAll(pageable).map(crimeReportMapper::toDto);
    }

    /**
     * Get one crimeReport by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CrimeReportDTO> findOne(Long id) {
        log.debug("Request to get CrimeReport : {}", id);
        return crimeReportRepository.findById(id).map(crimeReportMapper::toDto);
    }

    /**
     * Delete the crimeReport by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CrimeReport : {}", id);
        crimeReportRepository.deleteById(id);
    }
}
