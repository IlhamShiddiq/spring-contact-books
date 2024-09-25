package spring_basic.spring_basic_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_basic.spring_basic_api.entity.Address;
import spring_basic.spring_basic_api.repository.custom.CustomAddressRepository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>, CustomAddressRepository {
}
