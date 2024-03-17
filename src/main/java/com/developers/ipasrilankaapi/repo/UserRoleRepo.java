package com.developers.ipasrilankaapi.repo;



import com.developers.ipasrilankaapi.entity.UserRole;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface UserRoleRepo extends JpaRepository<UserRole,String> {
    @Query(value = "SELECT * FROM user_role WHERE role_name=?1",nativeQuery = true)
    public UserRole findUserRoleByRoleName(String role);

    @Query(value = "SELECT * FROM user_role WHERE active_state=?", nativeQuery = true)
    public List<UserRole> findAllWithPagination(boolean activeState, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM user_role WHERE active_state=?", nativeQuery = true)
    public long countAllByActiveState(boolean activeState);
    @Query(value = "SELECT * FROM user_role WHERE (role_name LIKE %?1% OR description LIKE %?1%)", nativeQuery = true)
    List<UserRole> findAllUserRoleBySearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM user_role WHERE (role_name LIKE %?1% OR description LIKE %?1%)", nativeQuery = true)
    long countAllBySearchText(String searchText);


}
