package library.app.backend.category;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;

    List<Category> categories;
    Category category;
    @BeforeEach
    void setUp() {
        this.categories = new ArrayList<>();
        this.category = new Category() {{
            setId(UUID.randomUUID());
            setName("Category");
            setDescription("Category Description");
            setCreatedAt(Instant.now());
        }};
    }

    @AfterEach
    void tearDown() {
        this.categories.clear();
        this.categories = null;
    }

    @Test()
    @DisplayName("Find all categories when table is empty")
    void find_All_all_when_category_is_empty() {
        var expected = this.categories;
        assertTrue(expected.isEmpty());
        Mockito.when(this.categoryRepository.findAll()).thenReturn(expected);
        var actual = this.categoryService.find();
        assertEquals(expected.stream().map(CategoryDto::toCategoryDto).toList(), actual);
        Mockito.verify(this.categoryRepository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName("Find all categories when table is not empty")
    void find_All_all_when_item_in_category() {
        this.categories.add(this.category);
        var expected = this.categories;
        Mockito.when(this.categoryRepository.findAll()).thenReturn(expected);
        var actual = this.categoryService.find();
        assertEquals(expected.stream().map(CategoryDto::toCategoryDto).toList(), actual);
        Mockito.verify(this.categoryRepository, Mockito.times(1)).findAll();
    }

    //todo: add flagging for data deletion and return categories instead of DTO
    @Test
    @DisplayName("Delete item when exists in the table")
    void delete_by_id_when_category_is_not_empty() {
        var expected = this.category;
        this.categoryService.delete(expected.getId());
        Mockito.verify(this.categoryRepository, Mockito.times(1)).deleteById(expected.getId());
        Mockito.verify(this.categoryRepository).deleteById(expected.getId());
    }

    @Test
    @DisplayName("save category into table when given a all required fields")
    void create_not_throw() {
        var expected = this.category;
        Mockito.when(this.categoryRepository.save(expected)).thenReturn(expected);
        var actual = this.categoryService.create(this.category);
        assertEquals(CategoryDto.toCategoryDto(expected), actual);
        Mockito.verify(this.categoryRepository, Mockito.times(1)).save(expected);
    }
    //todo: return categories instead of DTO
    @Test
    @DisplayName("find category by id when it exists in table")
    void find_All_by_id_when_category_is_not_empty() {
        var expected = this.category;
        Mockito.when(this.categoryRepository.findById(this.category.getId())).thenReturn(Optional.of(this.category));
        var actual = this.categoryService.find(this.category.getId());
        assertEquals(CategoryDto.toCategoryDto(expected), actual);
        Mockito.verify(this.categoryRepository, Mockito.times(1)).findById(this.category.getId());
    }

    @Test
    @DisplayName("update the supplied fields of a category in the table")
    void update_fields_not_throw () {
    }
}