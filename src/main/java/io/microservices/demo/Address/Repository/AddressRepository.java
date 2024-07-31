package io.microservices.demo.Address.Repository;


import io.microservices.demo.Address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
