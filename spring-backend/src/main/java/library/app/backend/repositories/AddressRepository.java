package library.app.backend.repositories;

import library.app.backend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address, String>, JpaSpecificationExecutor<Address> {
}