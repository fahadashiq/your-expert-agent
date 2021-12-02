package com.hsrw.yea.repository;

import com.hsrw.yea.domain.CrimeReport;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the CrimeReport entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {}
