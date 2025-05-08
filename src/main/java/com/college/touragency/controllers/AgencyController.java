package com.college.touragency.controllers;

import java.util.List;

import com.college.touragency.dto.AgencyDto;
import com.college.touragency.models.Agency;
import com.college.touragency.repositories.AgencyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {
    private final AgencyRepository agencyRepository;

    public AgencyController(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @GetMapping()
    public List<AgencyDto> getAll() {
        return agencyRepository
                .findAll()
                .stream()
                .map(AgencyDto::fromEntity)
                .toList();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Agency create(@RequestBody AgencyDto agencyDto) {
        Agency agency = agencyDto.toEntity();

        var newAgency = agencyRepository.save(agency);

        return newAgency;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Agency delete(@PathVariable("id") int id) {
        var agency = agencyRepository.
                findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agency not found with id: " + id));

        agencyRepository.delete(agency);

        return agency;
    }
}
