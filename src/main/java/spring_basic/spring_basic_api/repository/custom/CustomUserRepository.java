package spring_basic.spring_basic_api.repository.custom;

import spring_basic.spring_basic_api.entity.User;

import java.util.Optional;

public interface CustomUserRepository {

    public Optional<User> findFirstByToken(String token);

}
