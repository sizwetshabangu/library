package library.app.backend.reader;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReaderRepository extends JpaRepository<Reader, String>, JpaSpecificationExecutor<Reader> {
}