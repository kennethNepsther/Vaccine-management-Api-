package com.vacinas.config.profile;

import com.vacinas.enums.VaccineIntakeRoute;
import com.vacinas.model.RoleModel;
import com.vacinas.model.UserModel;
import com.vacinas.model.VaccineModel;
import com.vacinas.repository.RoleRepository;
import com.vacinas.repository.UserRepository;
import com.vacinas.repository.VaccineRepository;
import com.vacinas.util.DateTimeUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

@Configuration
@Profile("dev")
public class Dev {
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final VaccineRepository vaccineRepository;

    String[] vaccineName = {"BCG", "Hepatite B", "Penta", "Polio inativada", "Polio oral", "Rotavírus",
            "Pneumocócica 10-valente", "Meningocócica C", "Febre amarela",
            " Tríplice viral (SCR-sarampo caxumba e,rubéola)"};

    VaccineIntakeRoute[] intakeRoute = {VaccineIntakeRoute.ORAL, VaccineIntakeRoute.INTRADÉRMICA,
            VaccineIntakeRoute.SUBCUTÂNEA, VaccineIntakeRoute.INTRAMUSCULAR};
    String schedule = "Lorem Ipsum is simply dummy text ";
    String description = "dummy text of the printing and typesetting industry.";
    LocalDate manufactureDate = LocalDate.now();
    LocalDate expirationDate = manufactureDate.plusYears(8);
    public Dev(VaccineRepository vaccineRepository,UserRepository userRepository, RoleRepository roleRepository) {
        this.vaccineRepository = vaccineRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Bean
    public void startDB() {

        var roleAdmin = new RoleModel(null,"ROLE_ADMIN");
        var roleUser = new RoleModel(null,"ROLE_USER");
        roleRepository.saveAll(asList(roleAdmin,roleUser));

        var userAdmin = new UserModel(null,"Kenneth Luzolo","kenneth", new BCryptPasswordEncoder().encode("12345"), List.of(roleAdmin));
        var userUser = new UserModel(null,"Lando Luzolo","landinho",new BCryptPasswordEncoder().encode("12345"),List.of(roleUser));
        userRepository.saveAll(asList(userAdmin,userUser));

        var random = new SecureRandom();

        for (int i = 0; i < 10; i++) {

            int n1 = random.nextInt(10);
            int allotment = random.nextInt();
            int n3 = random.nextInt(4);

           var vaccine = new VaccineModel(null, vaccineName[n1],description, Integer.toString(allotment), "PANAMA", DateTimeUtil.getCurrentDate(),expirationDate,
                   intakeRoute[n3], schedule, "bla bla bla");

            vaccineRepository.save(vaccine);


        }


    }

}
