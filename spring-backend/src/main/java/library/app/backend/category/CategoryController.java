package library.app.backend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController()
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> get() {
        try{
            return new ResponseEntity<>(this.categoryService.find(), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public EntityModel<Category> get(@PathVariable("id") UUID id) {
            var category = this.categoryService.find(id);

            if (category == null) {
                throw new NoSuchElementException("Category not found");
            }else {
                var link = linkTo(CategoryController.class).slash(category.getId()).withSelfRel();
                //CollectionModel<Category> categoryCollectionModel = Collections.singletonList(category);
                return EntityModel.of(category, link);
            }

        /*catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") UUID id) {
        try {
            this.categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<CategoryDto> post(@RequestBody Category category) {
        try {
            if (category == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(
                    this.categoryService.create(category),
                    HttpStatus.CREATED);
        }catch (Exception exception){
            System.out.println(exception.getClass());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> put(@RequestBody Category category) {
        try {
            return new ResponseEntity<>(this.categoryService.update(category), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
