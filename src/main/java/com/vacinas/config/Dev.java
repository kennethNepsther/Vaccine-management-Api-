package com.vacinas.config;

import com.vacinas.model.VaccineIngestionMode;
import com.vacinas.model.VaccineModel;
import com.vacinas.repository.VaccineIngestionModeRepository;
import com.vacinas.repository.VaccineRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("dev")
public class Dev {
    final VaccineRepository vaccineRepository;
    final VaccineIngestionModeRepository vaccineIngestionModeRepository;

    public Dev(VaccineRepository vaccineRepository, VaccineIngestionModeRepository vaccineIngestionModeRepository) {
        this.vaccineRepository = vaccineRepository;
        this.vaccineIngestionModeRepository = vaccineIngestionModeRepository;
    }
    int i,n1,n2;
    String vaccine[] ={"Kenneth","Lansieth","Mimosa","Nsimba","Lando","Lajy","Adilson","Vani"};
    String description[] ={"Kenneth","Lansieth","Mimosa","Nsimba","Lando","Lajy","Adilson","Vani"};
//@Bean
//    public void startDB() {
//
//    var category1 = new VaccineIngestionMode(null,"Atenuadas");
//    var category2 = new VaccineIngestionMode(null,"Inativadas");
//    var category3 = new VaccineIngestionMode(null,"Subunidades");
//        vaccineIngestionModeRepository.saveAll(List.of(category1,category2,category3));
//
//        for (int i = 0; i < 20; i++) {
//            var vaccine = new VaccineModel(null,"Vaccine","description","type" );
//            vaccineRepository.save(vaccine);
//
//
//        }




  //  }

}
