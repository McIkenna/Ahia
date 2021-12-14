package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    void itShouldCheckIfIdExist() {
        //given
        Category cat = new Category("123L", "Phone", "This is for mobile phones", null, null);
        categoryRepository.save(cat);
        //when
        Category category = categoryRepository.findById("123L");
        boolean exist = false;
        if(category != null) {
            exist = true;
        }
        //then
        assertThat(exist).isTrue();
    }

    @Test
    void itShouldCheckIfIdDoesNotExist() {
        //given
        String id = "123L";
        //when
        Category category = categoryRepository.findById(id); //Here I checked if this Id is in the repository
        boolean expected = false;
        if(category != null) {
            expected = true;
        }
        //then
        assertThat(expected).isFalse();
    }
}