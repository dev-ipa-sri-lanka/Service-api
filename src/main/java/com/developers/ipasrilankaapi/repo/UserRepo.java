package com.developers.ipasrilankaapi.repo;


import com.developers.ipasrilankaapi.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM user WHERE user_name=?1", nativeQuery = true)
    public User findByUsername(String username);

    @Query(value = "SELECT * FROM user WHERE user_id=?1", nativeQuery = true)
    User findUser(String userId);

}
