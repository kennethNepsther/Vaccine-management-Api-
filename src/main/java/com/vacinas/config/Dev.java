package com.vacinas.config;

import com.vacinas.model.CategoryModel;
import com.vacinas.model.VaccineModel;
import com.vacinas.repository.CategoryRepository;
import com.vacinas.repository.VaccineRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("dev")
public class Dev {

    final VaccineRepository vaccineRepository;
    final CategoryRepository categoryRepository;

    public Dev(VaccineRepository vaccineRepository, CategoryRepository categoryRepository) {
        this.vaccineRepository = vaccineRepository;
        this.categoryRepository = categoryRepository;
    }
@Bean
    public void startDB() {

    var category1 = new CategoryModel(null,"Atenuadas");
    var category2 = new CategoryModel(null,"Inativadas");
    var category3 = new CategoryModel(null,"Subunidades");
        categoryRepository.saveAll(List.of(category1,category2,category3));

        /*for (int i = 0; i < 20; i++) {
            var vaccine = new VaccineModel(null,"Vaccine" +i);
            vaccineRepository.save(vaccine);


        }
*/



    }

}
