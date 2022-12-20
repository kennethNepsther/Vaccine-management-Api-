package com.vacinas.config;

import com.vacinas.enums.VaccineIntakeRoute;
import com.vacinas.model.VaccineIngestionMode;
import com.vacinas.model.VaccineModel;
import com.vacinas.repository.VaccineIngestionModeRepository;
import com.vacinas.repository.VaccineRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Configuration
@Profile("dev")
public class Dev {
    final VaccineRepository vaccineRepository;
    final VaccineIngestionModeRepository vaccineIngestionModeRepository;

    public Dev(VaccineRepository vaccineRepository, VaccineIngestionModeRepository vaccineIngestionModeRepository) {
        this.vaccineRepository = vaccineRepository;
        this.vaccineIngestionModeRepository = vaccineIngestionModeRepository;
    }
       String []vaccine ={"BCG","Hepatite B","Penta","Polio inativada","Polio oral","Rotavírus",
            "Pneumocócica 10-valente","Meningocócica C","Febre amarela"," Tríplice viral (SCR-sarampo caxumba e,rubéola)"};

    String[] age = {"Ao nascer", "2 meses", "4 meses", "6 meses", "8 meese", "10 meses", "1 ano", "2 anos", "10 anos", "14 anos"};
    String[] allotment = {"12121-121", "2121-12", "273156-a", "74574-2", "984587-e33"};
    VaccineIntakeRoute[] intakeRoute = {VaccineIntakeRoute.ORAL, VaccineIntakeRoute.INTRADÉRMICA, VaccineIntakeRoute.SUBCUTÂNEA};
    String schedule = "Lorem Ipsum is simply dummy text of the printing printer took a galley";
    String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
            " the industry's standard dummy text ever since the 1500s, when an unknown printer tookey";

@Bean
    public void startDB() {

    var random = new Random();

    for (int i = 0; i < 10; i++) {


       int n1 = 0 + random.nextInt(10);
       int n2 = 0 + random.nextInt(5);
        int n3 = 0 + random.nextInt(3);

        var ingestionMode1 = new VaccineIngestionMode(null, age[n1], schedule, description, null);

        vaccineIngestionModeRepository.save(ingestionMode1);



        var vaccine1 = new VaccineModel(null, vaccine[n1], description, allotment[n2], "PALANCA",
                LocalDateTime.now(), LocalDateTime.of(4,4,4,4,4), intakeRoute[n3], null);
        vaccineRepository.save(vaccine1);


    }




    }

}
