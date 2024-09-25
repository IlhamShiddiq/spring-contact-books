package spring_basic.spring_basic_api.repository.custom;

import spring_basic.spring_basic_api.entity.Contact;
import spring_basic.spring_basic_api.entity.User;

import java.util.Optional;

public interface CustomContactRepository {

    public Optional<Contact> findFirstByUserAndId(User user, String id);

}
