package com.college.touragency.controllers;

import java.util.List;

import com.college.touragency.dto.AgencyDto;
import com.college.touragency.repositories.AgencyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
