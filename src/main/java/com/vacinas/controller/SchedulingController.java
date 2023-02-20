package com.vacinas.controller;

import com.vacinas.model.PatientModel;
import com.vacinas.model.SchedulingModel;
import com.vacinas.model.dto.request.SchedulingRequestDto;
import com.vacinas.service.PatientService;
import com.vacinas.service.SchedulingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.vacinas.util.UriUtil.addIdToCurrentUrlPath;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/schedule")
@PreAuthorize("hasRole('ADMIN')")
public class SchedulingController {

    final SchedulingService schedulingService;

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingModel> findById(@PathVariable Long id) {
        SchedulingModel schedule = schedulingService.findById(id);
        return ResponseEntity.ok((schedule));
    }

    @GetMapping
    public ResponseEntity<List<SchedulingModel>> findAll() {
        List<SchedulingModel> schedules = schedulingService.findAll();
        return ResponseEntity.ok().body(schedules);
        //return ResponseEntity.ok(product.stream().map(SchedulingResponseDTO::new).collect(Collectors.toList()));
    }



    @PostMapping
    public ResponseEntity<SchedulingModel> create(@RequestBody SchedulingRequestDto schedulingDto){
        SchedulingModel schedule = schedulingService.create(schedulingDto.build());
        URI uri = addIdToCurrentUrlPath(schedule.getId());
        return ResponseEntity.created(uri).body(schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        schedulingService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
