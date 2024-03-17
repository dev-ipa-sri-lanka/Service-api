package com.developers.ipasrilankaapi.repo;

import com.developers.ipasrilankaapi.entity.UserRoleHasUser;
import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@EnableJpaRepositories
public interface UserRoleHasUserRepo extends JpaRepository<UserRoleHasUser,String> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_role_has_user WHERE user_id = ?1 AND role_id = ?2", nativeQuery = true)
    void deleteUserRoleHasUser(String lectureId, String programLanguageCostId);
    @Query(value = "SELECT * FROM user_role_has_user WHERE user_id = ?1", nativeQuery = true)
    List<UserRoleHasUser> findByUserId(String userId);

    @Query(value = "SELECT * FROM user_role_has_user WHERE role_id = ?1", nativeQuery = true)
    List<UserRoleHasUser> findByUserRoleId(String userId, Pageable pageable);

    @Query(value = "SELECT * FROM user_role_has_user WHERE role_id = ?1", nativeQuery = true)
    List<UserRoleHasUser> findByUserRoleId(String userId);
}
