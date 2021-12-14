package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.productContent.Category;
import com.shopping.ahia.models.productContent.Product;
import com.shopping.ahia.repository.CategoryRepository;
import com.shopping.ahia.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryImplementationTest {
    @Mock
    CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
    @InjectMocks
    CategoryImplementation categoryImplementation = new CategoryImplementation();
    @Mock
    ProductRepository productRepository = Mockito.mock(ProductRepository.class);

    @Test
    @DisplayName("Test Should Pass When Comment do not Contain Invalid Category")
    void categoryContains() throws Exception {
        CategoryImplementation categoryImplementation = new CategoryImplementation();
       assertThat(categoryImplementation.categoryContains("This is a clean category")).isFalse();
    }

    @Test
    @DisplayName("Should Throw Exception when Exception Contains Valid words")
    void categoryContainsValidWord() throws Exception {
        CategoryImplementation categoryImplementation = new CategoryImplementation();
//        Exception exception = assertThrows(Exception.class, () -> {
//            categoryImplementation.categoryContains("This is from Alaba international");
//        });
//       assertTrue(exception.getMessage().contains("Category contains Alaba"));
        assertThatThrownBy(() -> {
            categoryImplementation.categoryContains("This is from Alaba international");
        }).isInstanceOf(Exception.class).hasMessage("Category contains Alaba");
    }


    @Test
    @DisplayName("Should Find Category by Id")
    void shouldFindCategoryById() throws Exception {
        Category cat = new Category("123L", "Phone", "This is for mobile phones", null, null);
        Category catResponse = new Category("123L", "Phone", "This is for mobile phones", null, null);
        String testId = "123L";
        when(categoryRepository.findById(testId)).thenReturn(cat);
       // assertThat(categoryImplementation.findById(testId)).isEqualTo(catResponse);
        Assertions.assertEquals(categoryImplementation.findById(testId),catResponse);
    }

    @Test
    @DisplayName("Should Throw error for Id not found")
    void willThrowErrorCategoryById() throws Exception {
        String testId = "123L";
        //when(categoryRepository.findById(testId)).thenReturn(null);
        given(categoryRepository.findById(testId)).willReturn(null);
        assertThatThrownBy(() -> categoryImplementation.findById(testId))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Category with id " + testId + " does not exist");
        //verify(categoryRepository, never()).save(any());
    }


    @Test
    @DisplayName("Should Find Category by Name")
    void shouldFindCategoryByName() throws Exception {
        Category cat = new Category("123L", "Phone", "This is for mobile phones", null, null);
        Category catResponse = new Category("123L", "Phone", "This is for mobile phones", null, null);
        when(categoryRepository.findByCategoryName("Phone")).thenReturn(cat);
        assertThat(categoryImplementation.findByCategoryName("Phone")).isEqualTo(catResponse);
        //Assertions.assertEquals(categoryImplementation.findById("123L"),catResponse);
    }

//    @Test
//    @Disabled
//    void shouldDeleteById(){
//        Category cat = new Category("123L", "Phone", "This is for mobile phones", null, null);
//        Category catResponse = new Category("123L", "Phone", "This is for mobile phones", null, null);
//
//        given(categoryRepository.findById("123L")).willReturn(cat);
//        given(productRepository.findByCategoryId("123L")).willReturn(Product.class);
//
//    }

    @Test
    void canGetAllCategory(){ //This test if the method find all was invoked
        //when
        categoryImplementation.findAllCategory();
        //then
        verify(categoryRepository).findAll();
    }

//    @Test
//    void canSaveStudent() throws Exception {
//        //given
//        Category catResponse = new Category("123L", "Phone", "This is for mobile phones", null, null);
//
//
//        //when
//        categoryImplementation.save(null, catResponse);
//
//        //then
//        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
//        verify(categoryRepository).save(categoryArgumentCaptor.capture());
//        Category capturedCat = categoryArgumentCaptor.getValue();
//
//        assertThat(capturedCat).isEqualTo(catResponse);
//    }
}