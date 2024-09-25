package spring_basic.spring_basic_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_basic.spring_basic_api.entity.User;
import spring_basic.spring_basic_api.repository.custom.CustomUserRepository;

@Repository
public interface UserRepository extends JpaRepository<User, String>, CustomUserRepository {
}
