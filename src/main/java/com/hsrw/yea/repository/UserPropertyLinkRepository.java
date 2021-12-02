package com.hsrw.yea.repository;

import com.hsrw.yea.domain.UserPropertyLink;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the UserPropertyLink entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserPropertyLinkRepository extends JpaRepository<UserPropertyLink, Long> {
    @Query("select userPropertyLink from UserPropertyLink userPropertyLink where userPropertyLink.user.login = ?#{principal.username}")
    List<UserPropertyLink> findByUserIsCurrentUser();
}
