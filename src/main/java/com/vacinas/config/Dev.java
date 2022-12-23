package com.vacinas.config;

import com.vacinas.enums.VaccineIntakeRoute;
import com.vacinas.model.Role;
import com.vacinas.model.User;
import com.vacinas.model.VaccineIngestionMode;
import com.vacinas.model.VaccineModel;
import com.vacinas.repository.RoleRepository;
import com.vacinas.repository.UserRepository;
import com.vacinas.repository.VaccineIngestionModeRepository;
import com.vacinas.repository.VaccineRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.time.LocalDate;
import java.util.Random;

import static java.util.Arrays.asList;

@Configuration
@Profile("dev")
public class Dev {
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final VaccineRepository vaccineRepository;
    final VaccineIngestionModeRepository vaccineIngestionModeRepository;
    String[] vaccineName = {"BCG", "Hepatite B", "Penta", "Polio inativada", "Polio oral", "Rotavírus",
            "Pneumocócica 10-valente", "Meningocócica C", "Febre amarela",
            " Tríplice viral (SCR-sarampo caxumba e,rubéola)"};
    String[] age = {"Ao nascer", "2 meses", "4 meses", "6 meses", "8 meese", "10 meses", "1 ano", "2 anos",
            "10 anos", "14 anos"};
    VaccineIntakeRoute[] intakeRoute = {VaccineIntakeRoute.ORAL, VaccineIntakeRoute.INTRADÉRMICA,
            VaccineIntakeRoute.SUBCUTÂNEA, VaccineIntakeRoute.INTRAMUSCULAR};
    String schedule = "Lorem Ipsum is simply dummy text ";
    String description = "dummy text of the printing and typesetting industry.";
    LocalDate manufactureDate = LocalDate.now();
    LocalDate expirationDate = manufactureDate.plusYears(8);
    public Dev(VaccineRepository vaccineRepository,VaccineIngestionModeRepository vaccineIngestionModeRepository,
                UserRepository userRepository, RoleRepository roleRepository) {
        this.vaccineRepository = vaccineRepository;
        this.vaccineIngestionModeRepository = vaccineIngestionModeRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Bean
    public void startDB() {

        var roleAdmin = new Role(null,"ROLE_ADMIN");
        var roleUser = new Role(null,"ROLE_USER");
        roleRepository.saveAll(asList(roleAdmin,roleUser));

        var userAdmin = new User(null,"Kenneth Luzolo","kenneth","12345",null);
        var userUser = new User(null,"Lando Luzolo","landinho","12345",null);
        userRepository.saveAll(asList(userAdmin,userUser));

        var random = new Random();

        for (int i = 0; i < 10; i++) {

            int n1 = random.nextInt(10);
            int allotment = random.nextInt();
            int n3 = random.nextInt(4);

            var ingestionMode1 = new VaccineIngestionMode(null, age[n1], schedule, description, null);

            vaccineIngestionModeRepository.save(ingestionMode1);


            var vaccine1 = new VaccineModel(null, vaccineName[n1], description, Integer.toString(allotment),
                    "PALANCA",
                    manufactureDate, expirationDate, intakeRoute[n3], null);
            vaccineRepository.save(vaccine1);


        }


    }

}
