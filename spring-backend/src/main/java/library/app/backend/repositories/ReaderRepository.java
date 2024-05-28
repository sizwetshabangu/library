package library.app.backend.repositories;

import library.app.backend.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReaderRepository extends JpaRepository<Reader, String>, JpaSpecificationExecutor<Reader> {
}