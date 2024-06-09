package library.app.backend.category;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAll() {
        return this.categoryRepository.findAll()
                .stream()
                .map(CategoryDto::toCategoryDto)
                .toList();
    }

    public void deleteById(UUID id) {
        this.categoryRepository.deleteById(id);
    }

    public CategoryDto save(Category category) {
        category.setId(UUID.randomUUID());
        category.setCreatedAt(new Date().toInstant());
        category.setDeleted(false);
        return CategoryDto.toCategoryDto(this.categoryRepository.save(category));
    }

    public CategoryDto findById(UUID id) throws NoSuchElementException {
        var response = this.categoryRepository.findById(id).orElseThrow();
        return CategoryDto.toCategoryDto(response);
    }

    public CategoryDto update(Category category) {
        var categoryResponse = this.categoryRepository.save(category);
        return new CategoryDto(categoryResponse.getId(), category.getName(), category.getDescription());
    }


}
