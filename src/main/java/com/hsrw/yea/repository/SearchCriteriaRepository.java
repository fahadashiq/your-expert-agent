package com.hsrw.yea.repository;

import com.hsrw.yea.domain.SearchCriteria;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the SearchCriteria entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SearchCriteriaRepository extends JpaRepository<SearchCriteria, Long> {
    @Query("select searchCriteria from SearchCriteria searchCriteria where searchCriteria.user.login = ?#{principal.username}")
    List<SearchCriteria> findByUserIsCurrentUser();
}
