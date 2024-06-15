package library.app.backend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> find() {
        return this.categoryRepository.findAll()
                .stream()
                .map(CategoryDto::toCategoryDto)
                .toList();

    }

    public Category find(UUID id) throws NoSuchElementException {
        return this.categoryRepository.findById(id).orElseThrow();
    }

    public CategoryDto create(Category category) {
        if(!Objects.isNull(category)) {
            category.setId(UUID.randomUUID());
            category.setCreatedAt(Instant.now());
            category.setDeleted(false);
        }
        return CategoryDto.toCategoryDto(this.categoryRepository.save(category));
    }

    public CategoryDto update(Category category) {
        return CategoryDto.toCategoryDto(this.categoryRepository.save(category));
    }

    public void delete(UUID id) {
        this.categoryRepository.deleteById(id);
    }
}
