package library.app.backend.repositories;

import library.app.backend.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StaffRepository extends JpaRepository<Staff, String>, JpaSpecificationExecutor<Staff> {
}