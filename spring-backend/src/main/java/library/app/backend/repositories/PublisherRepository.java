package library.app.backend.repositories;

import library.app.backend.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PublisherRepository extends JpaRepository<Publisher, String>, JpaSpecificationExecutor<Publisher> {
}