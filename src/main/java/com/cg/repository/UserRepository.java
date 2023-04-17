package com.cg.repository;

import com.cg.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query(nativeQuery = true,
            value = "SELECT r.name FROM roles r INNER JOIN roles_users ru ON r.id = ru.role_id " +
                    "INNER JOIN users u ON ru.user_id = u.id WHERE u.username = :username")
    List<String> findRolesByUsername(@Param("username") String username);
}
