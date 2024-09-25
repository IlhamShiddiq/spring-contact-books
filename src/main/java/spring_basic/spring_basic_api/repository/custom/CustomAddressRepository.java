package spring_basic.spring_basic_api.repository.custom;

import spring_basic.spring_basic_api.entity.Address;
import spring_basic.spring_basic_api.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface CustomAddressRepository {

    public Optional<Address> findFirstByContactAndId(Contact contact, String id);

    public List<Address> findAllByContact(Contact contact);

}
