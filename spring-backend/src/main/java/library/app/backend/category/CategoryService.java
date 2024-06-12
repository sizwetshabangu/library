package library.app.backend.category;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.*;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

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
        //return CategoryDto.toCategoryDto(response);
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
