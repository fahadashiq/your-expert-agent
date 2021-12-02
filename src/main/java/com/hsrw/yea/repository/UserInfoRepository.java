package com.hsrw.yea.repository;

import com.hsrw.yea.domain.UserInfo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the UserInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {}
