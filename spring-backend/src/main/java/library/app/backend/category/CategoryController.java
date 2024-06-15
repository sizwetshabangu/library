package library.app.backend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.hal.HalModelBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController()
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;
    private final HalModelBuilder halModelBuilder = HalModelBuilder.halModel();


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> get() {
        try {
            return new ResponseEntity<>(this.categoryService.find(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<RepresentationModel<Category>> get(@PathVariable("id") UUID id) {
        try {
            Category category = this.categoryService.find(id);
            var link = linkTo(CategoryController.class).slash(category.getId()).withSelfRel();
            RepresentationModel<Category> rep = this.halModelBuilder.embed(category).link(link).build();
            return ResponseEntity.of(Optional.of(rep));
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") UUID id) {
        try {
            this.categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
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
        } catch (Exception exception) {
            System.out.println(exception.getClass());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> put(@RequestBody Category category) {
        try {
            return new ResponseEntity<>(this.categoryService.update(category), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
