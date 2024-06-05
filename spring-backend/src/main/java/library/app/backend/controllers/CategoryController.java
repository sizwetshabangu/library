package library.app.backend.controllers;

import library.app.backend.dto.CategoryDto;
import library.app.backend.models.Category;
import library.app.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController()
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAll() {
        try{
            return new ResponseEntity<>(this.categoryService.findAll(), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public HttpEntity<Category> getById(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(this.categoryService.findById(id), HttpStatus.OK);
        }catch (NoSuchElementException exception){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @DeleteMapping()
    public ResponseEntity<Category> delete(@RequestBody Category category) {
        try {
            this.categoryService.delete(category);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Category> add(@RequestBody Category category) {
        try {
            return new ResponseEntity<>(
                    this.categoryService.save(category),
                    HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
