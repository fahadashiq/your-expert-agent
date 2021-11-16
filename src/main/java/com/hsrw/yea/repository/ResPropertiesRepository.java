package com.hsrw.yea.repository;

import com.hsrw.yea.domain.ResProperties;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ResProperties entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResPropertiesRepository extends JpaRepository<ResProperties, Long> {}
