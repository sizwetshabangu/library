package library.app.backend.services;

import library.app.backend.dto.CategoryDto;
import library.app.backend.models.Category;
import library.app.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println(this.categoryRepository.findAll());
        System.out.println(this.categoryRepository.findById(UUID.fromString("14a0ed4d-1cda-11ef-8438-0242ac130002")));
        return this.categoryRepository.findAll()
                .stream()
                .map(value -> new CategoryDto(value.getId(), value.getName(), value.getDescription()))
                .toList();
    }

    public void deleteById(UUID id) {
        this.categoryRepository.deleteById(id);
    }

    public void delete(Category category) {
        this.categoryRepository.delete(category);
    }

    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category findById(UUID id) throws NoSuchElementException {
        return this.categoryRepository.findById(id).orElseThrow();
    }

    public CategoryDto put(Category category) {
        var categoryResponse = this.categoryRepository.save(category);
        return new CategoryDto(categoryResponse.getId(), category.getName(), category.getDescription());
    }


}
