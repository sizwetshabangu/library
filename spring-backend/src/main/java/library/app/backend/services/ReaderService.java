package library.app.backend.services;

import library.app.backend.models.Reader;
import library.app.backend.repositories.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
}
