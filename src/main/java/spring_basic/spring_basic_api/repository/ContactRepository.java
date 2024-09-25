package spring_basic.spring_basic_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import spring_basic.spring_basic_api.entity.Contact;
import spring_basic.spring_basic_api.repository.custom.CustomContactRepository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>, JpaSpecificationExecutor<Contact>, CustomContactRepository {
}
